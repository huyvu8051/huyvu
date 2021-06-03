package com.huyvu.controller;

import java.util.Calendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.huyvu.dto.OnRegistrationCompleteEvent;
import com.huyvu.dto.UserDTO;
import com.huyvu.entity.UserEntity;
import com.huyvu.entity.VerificationToken;
import com.huyvu.service.IUserService;

@Controller("registrationController")
public class RegistrationController {
	@Autowired
	private IUserService userSer;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private MessageSource messages;

	@GetMapping("/dang-ki")
	public ModelAndView registerPage() {
		ModelAndView mav = new ModelAndView("registration");
		UserDTO userDto = new UserDTO();
		mav.addObject("user", userDto);
		return mav;
	}

	@PostMapping("/dang-ki")
	public ModelAndView registerPage(@ModelAttribute @Valid UserDTO userDto, HttpServletRequest request,
			Errors errors) {

		try {
			UserDTO registered = userSer.registerNewUserAccount(userDto);
			String appUrl = request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(userDto, request.getLocale(), appUrl));
		} catch (RuntimeException e) {
			return new ModelAndView("emailError", "user", userDto);
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("registration");
			mav.addObject("message", "An account for that user/email already exist!");
			mav.addObject("user", userDto);
			return mav;
		}

		return new ModelAndView("successRegister", "user", userDto);
	}

	@GetMapping("/xac-minh-tai-khoan")
	public String confirmRegistration(WebRequest request, Model model, @RequestParam String token) {
		Locale locale = request.getLocale();
		String language = locale.getLanguage();
		VerificationToken verificationToken = userSer.getVerificationToken(token);

		if (verificationToken == null) {
			String message = messages.getMessage("auth.message.invalidToken", null, locale);
			model.addAttribute("message", message);
			return "redirect:/badUser.html?lang=" + language;
		}
		
		UserEntity user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();
		if((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			String messageValue = messages.getMessage("auth.message.expried",null, locale);
			model.addAttribute("message",messageValue);
			return "redirect:/badUser.html?lang=" + language;
		}
		user.setEnabled(true);
		userSer.saveRegisteredUser(user);
		return "redirect:/login.html?lang=" + language;
	}

}

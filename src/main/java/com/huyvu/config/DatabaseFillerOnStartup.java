package com.huyvu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.huyvu.entity.RoleEntity;
import com.huyvu.repository.RoleRepository;
import com.huyvu.repository.UserRepository;

@Component
public class DatabaseFillerOnStartup implements ApplicationListener {

    @Autowired
    private RoleRepository roleRepo;
    
    @Autowired
    private UserRepository userRepo;

    private static Logger logger = LoggerFactory.getLogger(DatabaseFillerOnStartup.class);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        logger.info("===================================" +event.toString());
        System.out.println("=========== Initiate database =============");
        RoleEntity entity = new RoleEntity("USER", "role-user");
        roleRepo.save(entity);
        
    }

}
package com.dnanh01.backend.config;

import com.dnanh01.backend.dao.iface.RoleDao;
import com.dnanh01.backend.dao.iface.UserDao;
import com.dnanh01.backend.model.domain.Role;
import com.dnanh01.backend.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ApplicationStartup {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void createAdminUser() {
        if (userDao.count() == 0) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            Role adminRole = roleDao.findByName("ADMIN").orElseGet(() -> {
                Role role = new Role();
                role.setName("ADMIN");
                return roleDao.save(role);
            });

            User adminUser = new User();
            adminUser.setEmail("admin@example.com");
            adminUser.setPasswordHash(passwordEncoder.encode("admin123"));
            adminUser.setRoles(Set.of(adminRole));
            userDao.save(adminUser);
            System.out.println("Admin user created");
        }
    }
}


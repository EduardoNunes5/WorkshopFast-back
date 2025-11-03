package com.eduardo.workshopfast.config;

import com.eduardo.workshopfast.dto.user.RegisterUserRequestDto;
import com.eduardo.workshopfast.entities.enums.RoleValuesEnum;
import com.eduardo.workshopfast.exceptions.ResourceAlreadyExistsException;
import com.eduardo.workshopfast.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    private final UserService userService;

    public AdminUserConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        final RegisterUserRequestDto requestDto = new RegisterUserRequestDto("admin", "123");

        try {
            userService.registerUser(requestDto, RoleValuesEnum.ADMINISTRATOR);
        }
        catch (ResourceAlreadyExistsException resourceAlreadyExistsException) {
            System.out.println("Admin already exists!");
        }
    }
}

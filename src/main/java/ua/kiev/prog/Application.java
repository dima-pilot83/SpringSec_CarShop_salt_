package ua.kiev.prog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import ua.kiev.prog.entity.CustomUser;
import ua.kiev.prog.entity.Services;
import ua.kiev.prog.entity.TestDrive;
import ua.kiev.prog.entity.enums.UserRole;
import ua.kiev.prog.service.ServicesService;
import ua.kiev.prog.service.TestDriveService;
import ua.kiev.prog.service.UserService;

import java.math.BigDecimal;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


   // admin, admin
   //user, 1111
    @Bean
    public CommandLineRunner demo(final UserService userService, final TestDriveService testDriveService, final ServicesService servicesService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userService.addUser(new CustomUser("admin", "d033e22ae348aeb5660fc2140aec35850c4da997", UserRole.ADMIN));
                userService.addUser(new CustomUser("user", "011c945f30ce2cbafc452f39840f025693339c42", UserRole.USER));

                testDriveService.addTestDrive(new TestDrive("X1","11/10/2017","Dima","2223344","a@mail.ua"));
                servicesService.addServices(new Services("Oil change",new BigDecimal(50)));
                servicesService.addServices(new Services("Computer check",new BigDecimal(120)));
            }
        };
    }
}
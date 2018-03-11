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

    //SHA-512 must be
    // admin, admin, salt
    //user, 1111, salt
    @Bean
    public CommandLineRunner demo(final UserService userService, final TestDriveService testDriveService,
            final ServicesService servicesService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userService
                        .addUser(new CustomUser("admin",
                                "3b10294d4d746080407194f52a917cb8e391867663741a025a833a1359fd4c9700df5d51c1889aa312cd69acee860f4e288935f2b82099f4865c75e39836b508",
                                "[B@ca423f", UserRole.ADMIN));
                userService.addUser(new CustomUser("user",
                        "722729147b73e7307ac11cb9ae92bf86bfc04e8a47c554aed463beb418ab7c592d6d706f0639d1a8af0a65b965722899acb07cdc78ab33f14c3896d0af7c193e",
                        "[B@2f40f3", UserRole.USER));

                testDriveService.addTestDrive(new TestDrive("X1", "11/10/2017", "Dima", "2223344", "a@mail.ua"));
                servicesService.addServices(new Services("Oil change", new BigDecimal(50)));
                servicesService.addServices(new Services("Computer check", new BigDecimal(120)));
            }
        };
    }
}
package ua.kiev.prog.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.entity.CustomUser;
import ua.kiev.prog.entity.Services;
import ua.kiev.prog.entity.TakenServices;
import ua.kiev.prog.entity.enums.UserRole;
import ua.kiev.prog.service.ServicesService;
import ua.kiev.prog.service.TakenServicesService;
import ua.kiev.prog.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;


@Controller
public class MyController {
    @Autowired
    private UserService userService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private TakenServicesService takenServicesService;

    private boolean NoDataSelected;
    private static final Logger log = Logger.getLogger(MyController.class);


    @RequestMapping("/")
    public String service(HttpSession session, HttpServletRequest request, Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);

        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.gettelNumber());
        model.addAttribute("name", dbUser.getName());
        model.addAttribute("carN", dbUser.getcarNumber());
        model.addAttribute("carT", dbUser.getcarType());
        model.addAttribute("vars", servicesService.getAll());
        model.addAttribute("inputStatus", NoDataSelected);

        if (takenServicesService.getTsByLogin(login) != null) {
            model.addAttribute("vars2", takenServicesService.getTsByLogin(login));
        }

        return "cabinet";
    }

    @RequestMapping(value = "/takeservices", method = RequestMethod.POST)
    public String deleteservices(Model model, @RequestParam(name = "takeS", required = false) long[] id,
                                 @RequestParam(required = false) String date) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);

        NoDataSelected = false;
        String finalName = "";
        BigDecimal finalPrice = new BigDecimal(0);

        try {
            if (id != null && date != "") {
                for (int j = 0; j < id.length; j++) {
                    Services dbservice = servicesService.getById(id[j]);
                    finalName = finalName + " " + dbservice.getName() + ",";
                    finalPrice = finalPrice.add(dbservice.getPrice());
                }
                TakenServices dbts = new TakenServices(login, date, finalName, finalPrice, dbUser);
                takenServicesService.addTakenServices(dbts);
            } else {
                NoDataSelected = true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            model.addAttribute("error_message", "There is an ERROR, try one more time");
            return "errorpage";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String carT,
                         @RequestParam(required = false) String carN) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        CustomUser dbUser = userService.getUserByLogin(login);
        dbUser.setEmail(email);
        dbUser.settelNumber(phone);
        dbUser.setName(name);
        dbUser.setcarType(carT);
        dbUser.setcarNumber(carN);

        userService.updateUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public String update(@RequestParam String login,
                         @RequestParam String password,
                         @RequestParam(required = false) String email,
                         @RequestParam(required = false) String phone,
                         @RequestParam(required = false) String name,
                         @RequestParam(required = false) String carT,
                         @RequestParam(required = false) String carN,
                         Model model) {
        if (userService.existsByLogin(login)) {
            model.addAttribute("exists", true);
            return "register";
        }

        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String passHash = encoder.encodePassword(password, null);

        CustomUser dbUser = new CustomUser(login, passHash, UserRole.USER, name, email, phone, carT, carN);
        userService.addUser(dbUser);

        return "redirect:/";
    }

    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/cars")
    public String cars() {
        return "cars";
    }

    @RequestMapping("/testdrive")
    public String testdrive() {
        return "testdrive";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }
}

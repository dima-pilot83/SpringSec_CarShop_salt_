package ua.kiev.prog.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.entity.CustomUser;
import ua.kiev.prog.entity.Services;
import ua.kiev.prog.service.ServicesService;
import ua.kiev.prog.service.TakenServicesService;
import ua.kiev.prog.service.TestDriveService;
import ua.kiev.prog.service.UserService;

import java.math.BigDecimal;

@Controller
public class AdminController {

    @Autowired
    private TestDriveService testDriveService;
    @Autowired
    private UserService userService;
    @Autowired
    private ServicesService servicesService;
    @Autowired
    private TakenServicesService takenServicesService;

    private static final Logger log2 = Logger.getLogger(AdminController.class);

    @RequestMapping("/admin")
    public String serviceAdmin(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String login = user.getUsername();

        model.addAttribute("login", login);
        model.addAttribute("roles", user.getAuthorities());

        return "admin";
    }

    @RequestMapping("/viewtd")
    public String viewTestDrive(Model model) {
        model.addAttribute("vars", testDriveService.getAll());
        return "viewtd";
    }


    @RequestMapping(value = "/sorttestdrive", method = RequestMethod.POST)
    public String sortTestDrive(Model model, @RequestParam String sortBy) {

        try {
            if ((sortBy).equals("car_type1")) {
                model.addAttribute("vars", testDriveService.sortBycarType());
            }
            if ((sortBy).equals("date1")) {
                model.addAttribute("vars", testDriveService.sortBydate());
            }
            if ((sortBy).equals("name1")) {
                model.addAttribute("vars", testDriveService.sortByname());
            }

        } catch (Exception e) {
            log2.error(e.getMessage());
            model.addAttribute("error_message", "Unable to sort testdrive, try one more time");
            return "errorpage";
        }

        return "viewtd";
    }

    @RequestMapping(value = "/sorttakenser", method = RequestMethod.POST)
    public String sortTakenServices(Model model, @RequestParam String sortBy) {

        try {
            if ((sortBy).equals("login1")) {
                model.addAttribute("vars", takenServicesService.sortBylogin());
            }
            if ((sortBy).equals("date1")) {
                model.addAttribute("vars", takenServicesService.sortBydate());
            }
            if ((sortBy).equals("price1")) {
                model.addAttribute("vars", takenServicesService.sortByprice());
            }
        } catch (Exception e) {
            log2.error(e.getMessage());
            model.addAttribute("error_message", "Unable to sort services, try one more time");
            return "errorpage";
        }

        return "viewtakenservices";
    }

    @RequestMapping("/viewcustom")
    public String viewCustomers(Model model) {
        model.addAttribute("vars", userService.getAll());
        return "viewcustom";
    }

    @RequestMapping("/viewcustom/{login}")
    public String viewCustomers2(Model model, @PathVariable(value = "login") String login) {

        CustomUser dbUser = userService.getUserByLogin(login);

        model.addAttribute("login", login);
        model.addAttribute("role", dbUser.getRole());
        model.addAttribute("email", dbUser.getEmail());
        model.addAttribute("phone", dbUser.gettelNumber());
        model.addAttribute("name", dbUser.getName());
        model.addAttribute("carN", dbUser.getcarNumber());
        model.addAttribute("carT", dbUser.getcarType());

        return "viewcustom2";
    }

    @RequestMapping("/viewservices")
    public String viewServices(Model model) {
        model.addAttribute("vars", servicesService.getAll());
        return "viewservices";
    }

    @RequestMapping(value = "/deleteservices", method = RequestMethod.POST)
    public String deleteServices(Model model, @RequestParam("deleteS") long[] id) {

        try {
            for (int j = 0; j < id.length; j++) {
                servicesService.delete(id[j]);
            }
        } catch (Exception e) {
            log2.error(e.getMessage());
            model.addAttribute("error_message", "Unable to delete service, try one more time");
            return "errorpage";
        }

        return "redirect:/viewservices";
    }

    @RequestMapping(value = "/addservice", method = RequestMethod.POST)
    public String addService(Model model, @RequestParam String name,
                             @RequestParam BigDecimal price) {

        Services dbServices = new Services();
        dbServices.setName(name);
        dbServices.setPrice(price);
        servicesService.addServices(dbServices);

        return "redirect:/viewservices";
    }

    @RequestMapping("/viewtakenservices")
    public String takenServices(Model model) {
        model.addAttribute("vars", takenServicesService.getAll());
        return "viewtakenservices";
    }
}

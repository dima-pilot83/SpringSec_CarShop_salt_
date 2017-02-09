package ua.kiev.prog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kiev.prog.entity.TestDrive;
import ua.kiev.prog.service.TestDriveService;


@Controller
public class TestDriveController {
    @Autowired
    private TestDriveService testDriveService;

    @RequestMapping(value = "/newtestdrive", method = RequestMethod.POST)
    public String newtestdrive(@RequestParam String carT,
                               @RequestParam String date,
                               @RequestParam String name,
                               @RequestParam String phone,
                               @RequestParam String email
    ) {

        TestDrive dbTest = new TestDrive();

        dbTest.setcarType(carT);
        dbTest.setDate(date);
        dbTest.setName(name);
        dbTest.settelNumber(phone);
        dbTest.setEmail(email);

        testDriveService.addTestDrive(dbTest);

        return "index";
    }

}

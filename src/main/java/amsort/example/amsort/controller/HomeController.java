package amsort.example.amsort.controller;

import amsort.example.amsort.service.EmployeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    private EmployeService employeService;

    public HomeController(EmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("employeList")
    public String listEmploye(Model model){
        model.addAttribute("employeList", employeService.getEmployeList());
        return "employe";
    }

    @GetMapping("res")
    public String res(ModelMap modelMap, @RequestParam Double loan, @RequestParam String name){
        if (employeService.getEmployeByName(name).equals(name)) {
            double resultAdd = employeService.add(loan);
            double resultSubstract = employeService.substraction(loan);
            modelMap.put("name", employeService.getEmployeByName(name));
            modelMap.put("resultAdd", resultAdd);
            modelMap.put("resultSub", resultSubstract);
        }
        return "res";
    }

}

package ru.pasha.burger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pasha.burger.repos.BurgerRepo;

@Controller
public class MainController {

    private final BurgerRepo burgerRepo;

    public MainController(BurgerRepo burgerRepo) {
        this.burgerRepo = burgerRepo;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("burgers", burgerRepo.findAll().subList(0, 8));

        model.addAttribute("burger_with_order", burgerRepo.findAll(
                Sort.by(Sort.Direction.DESC, "price")
        ).subList(0, 2));

        return "index";
    }
}

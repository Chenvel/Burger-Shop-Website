package ru.pasha.burger.controllers;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.pasha.burger.repos.BurgerRepo;

@Controller
public class MenuController {

    private final BurgerRepo burgerRepo;

    public MenuController(BurgerRepo burgerRepo) {
        this.burgerRepo = burgerRepo;
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("burgers", burgerRepo.findAll());

        model.addAttribute("burger_with_order", burgerRepo.findAll(
                Sort.by(Sort.Direction.DESC, "price")
        ).subList(0, 2));

        return "menu";
    }
}

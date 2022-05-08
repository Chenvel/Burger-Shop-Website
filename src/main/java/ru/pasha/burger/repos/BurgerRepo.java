package ru.pasha.burger.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pasha.burger.entities.Burger;

public interface BurgerRepo extends JpaRepository<Burger, Long> {
}

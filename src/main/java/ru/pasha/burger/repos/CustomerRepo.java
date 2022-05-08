package ru.pasha.burger.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pasha.burger.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}

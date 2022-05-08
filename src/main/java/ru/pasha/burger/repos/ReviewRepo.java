package ru.pasha.burger.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pasha.burger.entities.Review;

public interface ReviewRepo extends JpaRepository<Review, Long> {
}

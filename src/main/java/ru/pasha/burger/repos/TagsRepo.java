package ru.pasha.burger.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pasha.burger.entities.Tags;

public interface TagsRepo extends JpaRepository<Tags, Long> {
}

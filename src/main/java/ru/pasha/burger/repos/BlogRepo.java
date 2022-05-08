package ru.pasha.burger.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pasha.burger.entities.Blog;

public interface BlogRepo extends JpaRepository<Blog, Long> {

    Page<Blog> findAll(Pageable pageable);
}

package ru.pasha.burger.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToMany(mappedBy = "reviews")
    private List<Blog> blogs = new ArrayList<>();

    public void setBlogs(Blog blog) {
        blogs.add(blog);
    }
}

package ru.pasha.burger.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Burger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 3)
    private Integer price;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false, length = 255)
    private String imagePath;

    @Column(nullable = false, length = 255)
    private String roundImagePath;
}

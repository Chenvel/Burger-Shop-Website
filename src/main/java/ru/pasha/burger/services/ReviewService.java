package ru.pasha.burger.services;

import org.springframework.stereotype.Service;
import ru.pasha.burger.entities.Blog;
import ru.pasha.burger.entities.Review;
import ru.pasha.burger.repos.CustomerRepo;
import ru.pasha.burger.repos.ReviewRepo;

import java.util.Date;


@Service
public class ReviewService {

    private final CustomerRepo customerRepo;

    private final ReviewRepo reviewRepo;

    private Long idCounter = 5L;

    public ReviewService(CustomerRepo customerRepo, ReviewRepo reviewRepo) {
        this.customerRepo = customerRepo;
        this.reviewRepo = reviewRepo;
    }


    public void save(Review review, Blog blog) {
        review.setId(idCounter++);
        review.setDate(new Date());
        review.setCustomer(customerRepo.findById(1L).get());

        review.setBlogs(blog);
        blog.setReviews(review);

        reviewRepo.save(review);
    }
}

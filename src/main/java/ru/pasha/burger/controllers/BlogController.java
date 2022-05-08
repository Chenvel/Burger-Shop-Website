package ru.pasha.burger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pasha.burger.entities.Blog;
import ru.pasha.burger.entities.Review;
import ru.pasha.burger.exceptions.BlogNotFoundException;
import ru.pasha.burger.repos.BlogRepo;
import ru.pasha.burger.repos.TagsRepo;
import ru.pasha.burger.services.ReviewService;

import java.util.Optional;

@Controller
public class BlogController {

    private final BlogRepo blogRepo;
    private final TagsRepo tagsRepo;
    private final ReviewService reviewService;

    public BlogController(BlogRepo blogRepo, ReviewService reviewService, TagsRepo tagsRepo) {
        this.blogRepo = blogRepo;
        this.reviewService = reviewService;
        this.tagsRepo = tagsRepo;
    }

    @GetMapping("/blog")
    public String blog(
            Model model,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Blog> page = blogRepo.findAll(pageable);

        model.addAttribute("blogs", page);

        model.addAttribute("recent_blogs", blogRepo.findAll(
                Sort.by(Sort.Direction.DESC, "date")).subList(0, 4)
        );

        model.addAttribute("tags", tagsRepo.findAll());

        return "blog";
    }

    @GetMapping("/blog/{id}")
    public String singleBlog(Model model, @PathVariable Long id) {
        try {
            model.addAttribute("blog", blogRepo.findById(id).orElseThrow(
                    BlogNotFoundException::new
            ));
        } catch (BlogNotFoundException ignored) {
            return "404";
        }

        Long nextBlogId = id + 1;
        Long prevBlogId = id - 1;

        Blog nextBlog = blogRepo.findById(nextBlogId).orElse(new Blog());
        Blog prevBlog = blogRepo.findById(prevBlogId).orElse(new Blog());

        model.addAttribute("next_blog", nextBlog);
        model.addAttribute("prev_blog", prevBlog);

        model.addAttribute("recent_blogs", blogRepo.findAll(
                Sort.by(Sort.Direction.DESC, "date")).subList(0, 4)
        );

        model.addAttribute("tags", tagsRepo.findAll());

        return "single-blog";
    }

    @PostMapping("/blog/{id}/add")
    public String addReview(@PathVariable Long id, @ModelAttribute Review review) {
        Blog blog;

        try {
             blog = blogRepo.findById(id).orElseThrow(
                    BlogNotFoundException::new
            );
        } catch (BlogNotFoundException e) {
            return "404";
        }

        reviewService.save(review, blog);

        return String.format("redirect:/blog/%s", id);
    }
}

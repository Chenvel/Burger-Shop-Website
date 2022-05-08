package ru.pasha.burger.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 20)
    private String shortName;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, length = 100)
    private String imagePath;

    @Column(nullable = false, length = 5000)
    private String text;

    @ManyToMany
    @JoinTable(
            name = "blog_tags",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "tags_id")
    )
    private List<Tags> tags;

    @ManyToMany
    @JoinTable(
            name = "blog_reviews",
            joinColumns = @JoinColumn(name = "blog_id"),
            inverseJoinColumns = @JoinColumn(name = "review_id")
    )
    private List<Review> reviews = new ArrayList<>();

    public String getReviewsSize() {
        return Integer.toString(reviews.size());
    }

    public List<String> getTextForView() {
        return List.of(getText().split("<p>"));
    }

    public void setReviews(Review review) {
        reviews.add(review);
    }

    public String getDay() {
        return Integer.toString(getDate().getDay());
    }

    public String getMonth() {


        switch (getDate().getMonth()) {
            case Calendar.FEBRUARY: return "Feb";
            case Calendar.MARCH: return "Mar";
            case Calendar.APRIL: return "Apr";
            case Calendar.MAY: return "May";
            case Calendar.JUNE: return "Jun";
            case Calendar.JULY: return "Jul";
            case Calendar.SEPTEMBER: return "Sep";
            case Calendar.OCTOBER: return "Oct";
            case Calendar.NOVEMBER: return "Nov";
            case Calendar.DECEMBER: return "Dec";
            default: return "Jan";
        }
    }
}

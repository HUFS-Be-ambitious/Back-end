package hufs.capstone.demo.model;

import hufs.capstone.demo.dto.ReviewDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter

public class Review {
    @Id
    @GeneratedValue
    @Column(name = "storeReviewId")
    private Long id;

    @Column
    private String personalStoreScore;

    @Column
    private String reviewDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Member member;

    public Review() {
        this.personalStoreScore = personalStoreScore;
        this.reviewDetail = reviewDetail;
    }

    public void update(ReviewDto reviewDto) {
        this.personalStoreScore = reviewDto.getPersonalStoreScore();
        this.reviewDetail = reviewDto.getReviewDetail();
    }
}

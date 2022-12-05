package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private String personalStoreScore;
    private String reviewDetail;

    public static ReviewDto of (Review r) {
        return new ReviewDto(
                r.getPersonalStoreScore(),
                r.getReviewDetail()
        );
    }
}

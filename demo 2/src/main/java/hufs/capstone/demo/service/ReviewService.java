/*package hufs.capstone.demo.service;


import hufs.capstone.demo.dto.ReviewDto;
import hufs.capstone.demo.model.Review;
import hufs.capstone.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReviewService{
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MemberService memberService;

    public List<ReviewDto> getReview(Long memberId) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        List<Review> reviewList = reviewRepository.findAllByMemberId(memberId);
        for(Review review : reviewList) {
            reviewDtoList.add(generateReviewDto(review));
        }
        return reviewDtoList;
    }

    public List<ReviewDto> getReviewByStoreId(Long storeId) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        List<Review> reviewList = reviewRepository.findReviewById(storeId);
        for(Review review : reviewList) {
            reviewDtoList.add(generateReviewDto(review));
        }
        return reviewDtoList;
    }

    private ReviewDto generateReviewDto(Review review) {
        return ReviewDto.builder()
                .personalStoreScore(review.getPersonalStoreScore())
                .reviewDetail(review.getReviewDetail())
                .build();
    }

    public Long createReview(String nickname, Long memberId, Long storeId, String reviewDetail, String personalStoreScore) {
        Review review = new Review();
        review.setPersonalStoreScore(personalStoreScore);
        review.setReviewDetail(reviewDetail);
        review.setMember(memberService.findMemberById(memberId));
        reviewRepository.save(review);
        return review.getId();
    }

    public void updateReview(ReviewDto reviewDto, Long storeReviewId){
        Review review = reviewRepository.findById(storeReviewId).orElseThrow(
                () -> new IllegalArgumentException("수정할 댓글이 존재하지 않습니다")
        );
        review.update(reviewDto);
    }

    public void deleteReview(Long storeReviewId) {
        Review review = reviewRepository.findById(storeReviewId).orElseThrow(
                () -> new IllegalArgumentException("삭제할 댓글이 존재하지 않습니다")
        );
        reviewRepository.delete(review);
    }

    public List<Review> findByMemberId(Long memberId) {
        return reviewRepository.findAllByMemberId(memberId);

    }

}
 */

package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByMemberId(Long memberId);
    List<Review> findReviewById(Long storeReviewId);
}

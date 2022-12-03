/*package hufs.capstone.demo.controller;

import hufs.capstone.demo.dto.ReviewDto;
import hufs.capstone.demo.service.MemberService;
import hufs.capstone.demo.service.ReviewService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController
@AllArgsConstructor
public class ReviewController {
    public final ReviewService reviewService;
    public final MemberService memberService;
    // review 작성

    @PostMapping("/api/review/add/{memberId}/{storeId}")
    public Map<String, String> writeReview(@PathVariable("memberId")Long memberId, @PathVariable("storeId") Long storeId, @RequestBody Map<String,String> map) throws Exception{
        if(memberService.findMemberById(memberId) == null) {
            throw new Exception("존재하지 않는 사용자");
        }
        String reviewDetail = map.get("reviewDetail");
        String personalStoreScore = map.get("personalStoreScore");
        String nickname = memberService.findNicknameById(memberId);
        Long storeReviewId = reviewService.createReview(nickname, memberId, storeId, reviewDetail, personalStoreScore);
        Map<String, String> map1 = new HashMap<>();
        map1.put("storeReviewId", storeReviewId.toString());

        return map1;
    }

    @PutMapping("/api/review/add/{memberId}/{storeReviewId}")
    public void updateReview(@PathVariable("memberId") Long memberId, @PathVariable("storeReviewId") Long storeReviewId,
                             @RequestBody ReviewDto reviewDto) {
        reviewService.updateReview(reviewDto, storeReviewId);
    }

    @DeleteMapping("/api/review/remove/{storeReviewId}")
    public void deleteReview(@PathVariable Long storeReviewId) {
        reviewService.deleteReview(storeReviewId);

    }

    @GetMapping("/api/review/findReview/{memberId}")
    public ResponseEntity<List<ReviewDto>> getReview(@PathVariable Long memberId) {
        return ResponseEntity.ok().body(reviewService.getReview(memberId));
    }

    // 가게 아이디로
    @GetMapping("/api/review/findReviewByStore/{storeId}")
    public ResponseEntity<List<ReviewDto>> reviewByStoreId(@PathVariable Long storeId) {
        return ResponseEntity.ok().body(reviewService.getReviewByStoreId(storeId));
    }


}

 */

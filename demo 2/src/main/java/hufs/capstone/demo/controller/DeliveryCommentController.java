package hufs.capstone.demo.controller;

import hufs.capstone.demo.dto.DeliveryCommentRequestDto;
import hufs.capstone.demo.service.DeliveryCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DeliveryCommentController {
    private final DeliveryCommentService commentService;

    //댓글 작성
    @PostMapping("/deliverypost/{deliveryPostSeq}/comments")
    public void commentWrite(@PathVariable Long deliveryPostSeq, @RequestBody DeliveryCommentRequestDto commentDto) {
        String userId = "WindowJelly"; //userId 불러오기
        commentService.commentWrite(userId, deliveryPostSeq, commentDto);
    }

    //댓글 수정
    @PutMapping({"/deliverypost/{deliveryPostSeq}/comments/{commentId}"})
    public void update(@PathVariable Long deliveryPostSeq, @PathVariable Long commentId, @RequestBody DeliveryCommentRequestDto commentDto) {
        commentService.update(commentId, commentDto);
    }

    //댓글 삭제
    @DeleteMapping("/deliverypost/{deliveryPostSeq}/comments/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentService.delete(commentId);
    }


}

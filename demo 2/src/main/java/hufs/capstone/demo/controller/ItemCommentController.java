package hufs.capstone.demo.controller;

import hufs.capstone.demo.dto.ItemCommentRequestDto;
import hufs.capstone.demo.service.ItemCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class ItemCommentController {
    private final ItemCommentService itemCommentService;

    //댓글 작성
    @PostMapping("/itempost/{itemPostSeq}/comments")
    public void commentWrite(@PathVariable Long itemPostSeq, @RequestBody ItemCommentRequestDto commentDto, HttpSession session) {
        String userId = (String)session.getAttribute("id"); //userId 불러오기
        itemCommentService.commentWrite(userId, itemPostSeq, commentDto);
    }

    //댓글 수정
    @PutMapping({"/itempost/{itemPostSeq}/comments/{commentId}"})
    public void update(@PathVariable Long itemPostSeq, @PathVariable Long commentId, @RequestBody ItemCommentRequestDto commentDto) {
        itemCommentService.update(commentId, commentDto);
    }

    //댓글 삭제
    @DeleteMapping("/itempost/{itemPostSeq}/comments/{commentId}")
    public void delete(@PathVariable Long commentId) {
        itemCommentService.delete(commentId);
    }


}

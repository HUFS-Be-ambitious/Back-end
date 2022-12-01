package hufs.capstone.demo.controller;//package com.project.capstoneproject.controller;
//
//import com.project.capstoneproject.dto.ItemCommentRequestDto;
//import com.project.capstoneproject.service.ItemGuestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//public class RegistrationController {
//    private final ItemGuestService itemGuestService;
//
//    //공구 게스트 등록
//    @PostMapping("/itempost/{itemPostSeq}/guests")
//    public void guestSave(@PathVariable Long itemPostSeq, @RequestBody ItemGuestRequestDto guestDto) {
////        String Nickname = userSessionDto.getNickname(); //
//        itemGuestService.guestSave(itemPostSeq, guestDto);
//    }
//
//    @PutMapping({"/itempost/{itemPostSeq}/comments/{commentId}"})
//    public void update(@PathVariable Long itemPostSeq, @PathVariable Long commentId, @RequestBody ItemCommentRequestDto commentDto) {
//        commentService.update(commentId, commentDto);
//    }
//
//    @DeleteMapping("/itempost/{itemPostSeq}/comments/{commentId}")
//    public void delete(@PathVariable Long commentId) {
//        commentService.delete(commentId);
//    }
//}

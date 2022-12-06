package hufs.capstone.demo.dto;//package com.project.capstoneproject.dto;
//
//import com.project.capstoneproject.entity.ItemComment;
//import com.project.capstoneproject.entity.ItemGuestList;
//import com.project.capstoneproject.entity.ItemPost;
//import com.project.capstoneproject.entity.Member;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class ItemGuestRequestDto {
//
//    private Long listId;
//    private String hostId;
//    private String guestId;
//    private ItemPost itemPost;
//    private String joinDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
//
//    /* Dto -> Entity */
//    public ItemGuestList toEntity() {
//        ItemGuestList guestList = ItemGuestList.builder()
//                .listId(listId)
//                .hostId(hostId)
//                .guestId(guestId)
//                .itemPost(itemPost)
//                .joinDate(joinDate)
//                .build();
//        return guestList;
//    }
//}
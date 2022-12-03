package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.ItemComment;
import hufs.capstone.demo.entity.ItemPost;
import hufs.capstone.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemCommentRequestDto {
    private Long commentId;
    private String comment;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Member member;
    private ItemPost itemPost;

    /* Dto -> Entity */
    public ItemComment toEntity() {
        ItemComment comments = ItemComment.builder()
                .commentId(commentId)
                .comment(comment)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .member(member)
                .itemPost(itemPost)
                .build();

        return comments;
    }
}
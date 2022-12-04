package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.DeliveryComment;
import hufs.capstone.demo.entity.DeliveryPost;
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
public class DeliveryCommentRequestDto {
    private Long commentId;
    private String comment;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Member member;
    private DeliveryPost deliveryPost;

    /* Dto -> Entity */
    public DeliveryComment toEntity() {
        DeliveryComment comments = DeliveryComment.builder()
                .commentId(commentId)
                .comment(comment)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .member(member)
                .deliveryPost(deliveryPost)
                .build();

        return comments;
    }
}
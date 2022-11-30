package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.DeliveryComment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class DeliveryCommentResponseDto {
    private Long commentId;
    private String comment;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

    private String nickname;
    private Long deliveryPostSeq;

    public DeliveryCommentResponseDto(DeliveryComment deliveryComment) {
        this.commentId = deliveryComment.getCommentId();
        this.comment = deliveryComment.getComment();
        this.createdDate = deliveryComment.getCreatedDate();
        this.modifiedDate = deliveryComment.getModifiedDate();
//        this.nickname = deliveryComment.getUser().getNickname();
        this.deliveryPostSeq = deliveryComment.getDeliveryPost().getDeliveryPostSeq();
    }
}

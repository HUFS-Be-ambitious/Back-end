package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.ItemComment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class ItemCommentResponseDto {
    private Long commentId;
    private String comment;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

    private String nickname;
    private Long itemPostSeq;
    
    public ItemCommentResponseDto(ItemComment itemComment) {
        this.commentId = itemComment.getCommentId();
        this.comment = itemComment.getComment();
        this.createdDate = itemComment.getCreatedDate();
        this.modifiedDate = itemComment.getModifiedDate();
//        this.nickname = itemComment.getUser().getNickname();
        this.itemPostSeq = itemComment.getItemPost().getItemPostSeq();
    }
}

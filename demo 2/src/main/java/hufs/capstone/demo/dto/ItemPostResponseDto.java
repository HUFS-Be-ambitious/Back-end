package hufs.capstone.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ItemPostResponseDto {
    private Long itemPostSeq;
    private String title;
    private String host_id;
    private String image_path;
    private Long price;
    @Builder
    public ItemPostResponseDto(Long itemPostSeq, String title, String host_id, String image_path, Long price) {
        this.itemPostSeq = itemPostSeq;
        this.title = title;
        this.host_id = host_id;
        this.image_path = image_path;
        this.price = price;
    }
}

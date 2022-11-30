package hufs.capstone.demo.dto;

import lombok.Builder;

public class DeliveryPostResponseDto {
    private Long deliveryPostSeq;
    private String title;
    private String host_id;
    private String image_path;

    @Builder
    public DeliveryPostResponseDto(Long deliveryPostSeq, String title, String host_id, String image_path) {
        this.deliveryPostSeq = deliveryPostSeq;
        this.title = title;
        this.host_id = host_id;
        this.image_path = image_path;
    }
}

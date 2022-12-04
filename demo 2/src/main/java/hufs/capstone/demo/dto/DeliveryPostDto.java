package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.DeliveryPost;
import lombok.Getter;

import java.util.List;

@Getter
public class DeliveryPostDto {
    private Long deliveryPostSeq;
    private String title;
    private String store_name;
    private String storeCategory;
    private Long delivery_fee;
    private Long present_num;
    private Long done_num;
    private String endTime;
    private Long point;
    private Long person_price;
    private String host_id;
    private Long mannerscore;
    private String content;
    private String image_path;

    private List<DeliveryCommentResponseDto> comments;

    private List<DeliveryGuestResponseDto> guests;

    public DeliveryPostDto(DeliveryPost entity) {
        this.deliveryPostSeq = entity.getDeliveryPostSeq();
        this.title = entity.getTitle();
        this.store_name = entity.getStore_name();
        this.storeCategory = entity.getStoreCategory();
//        this.present_num = entity.getPresent_num();
        this.done_num = entity.getDone_num();
        this.endTime = entity.getEndTime();
        this.delivery_fee = entity.getDelivery_fee();
//        this.host_id = entity.getUser().getUserId();
//        this.mannerscore = entity.getUser().getMannerscore();
        this.content = entity.getContent();
        this.image_path = entity.getImage_path();
    }
}



package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.DeliveryPost;
import hufs.capstone.demo.model.StoreMenu;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class DeliveryPostDto {
    private Long deliveryPostSeq;
    private String title;
    private String storeName;
    private String storeCategory;
    private Long delivery_fee;
    private Integer present_num;

    private String endTime;
    private Long done_num;

    private Long point;
    private Long person_price;
    private String host_id;

    private String host_account;
    private Integer mScore;
    private String content;
    private String image_path;
    private List<DeliveryCommentResponseDto> comments;
    private List<DeliveryGuestResponseDto> guests;
    private List<String> menu;

    public DeliveryPostDto(DeliveryPost entity, List<String> storeMenu) {
        this.deliveryPostSeq = entity.getDeliveryPostSeq();
        this.title = entity.getTitle();
        this.storeName = entity.getStoreName();
        this.storeCategory = entity.getStoreCategory();
        this.present_num = entity.getPresent_num();
        this.done_num = entity.getDone_num();
        this.endTime = entity.getEndTime();
        this.delivery_fee = entity.getDelivery_fee();
        this.host_id = entity.getHost_id();
        this.host_account = entity.getHost_account();
        this.mScore = entity.getMScore();
        this.content = entity.getContent();
        this.image_path = entity.getImage_path();
        this.comments = entity.getComments().stream().map(DeliveryCommentResponseDto::new).collect(Collectors.toList());
        this.guests = entity.getGuests().stream().map(DeliveryGuestResponseDto::new).collect(Collectors.toList());
        this.menu = storeMenu;
    }
}



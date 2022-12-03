package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.ItemPost;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ItemPostDto {
    private Long itemPostSeq;
    private String title;
    private String item_name;
    private Long price;
    private Long delivery_fee;

    private String itemCategory;
    private Integer present_num;
    private Long done_num;
    private String endTime;
    private Long point;
    private Long person_price;
    private String host_id;
    private Long mannerscore;
    private String content;
    private String image_path;

    private String state;
    private List<ItemCommentResponseDto> comments;
    private List<ItemGuestResponseDto> guests;

    public ItemPostDto(ItemPost entity) {
        this.itemPostSeq = entity.getItemPostSeq();
        this.title = entity.getTitle();
        this.item_name = entity.getItem_name();
        this.present_num = entity.getPresent_num();
        this.done_num = entity.getDone_num();
        this.endTime = entity.getEndTime();
        this.price = entity.getPrice();
        this.delivery_fee = entity.getDelivery_fee();
        this.person_price = (entity.getPrice() + entity.getDelivery_fee()) / entity.getDone_num();
        this.itemCategory = entity.getItemCategory();
//        this.host_id = entity.getUser().getUserId();
//        this.mannerscore = entity.getUser().getMannerscore();
        this.content = entity.getContent();
        this.image_path = entity.getImage_path();
        this.comments = entity.getComments().stream().map(ItemCommentResponseDto::new).collect(Collectors.toList());
        this.guests = entity.getGuests().stream().map(ItemGuestResponseDto::new).collect(Collectors.toList());
    }
}



package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.ItemPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemPostWriteDto {
//    private User user;
    private String title;
    private String item_name;
    private String itemCategory;
    private Long price;
    private Long delivery_fee;
    private String endTime;
    private Long done_num;
    private String location;
    private String content;
    private Long point;

    @Builder
    public ItemPostWriteDto(String title, String item_name, String itemCategory,
                            Long price, Long delivery_fee, String endTime,
                            Long done_num, String location, String content, Long point) {
        this.title = title;
        this.item_name = item_name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.delivery_fee = delivery_fee;
        this.endTime = endTime;
        this.done_num = done_num;
        this.location = location;
        this.content = content;
        this.point = point;
    }

    /* Dto -> Entity */
    public ItemPost toEntity() {
        return ItemPost.builder()
//                .user(user)
                .title(title)
                .item_name(item_name)
                .itemCategory(itemCategory)
                .price(price)
                .delivery_fee(delivery_fee)
                .endTime(endTime)
                .done_num(done_num)
                .location(location)
                .content(content)
                .point(point)
                .build();
    }
}

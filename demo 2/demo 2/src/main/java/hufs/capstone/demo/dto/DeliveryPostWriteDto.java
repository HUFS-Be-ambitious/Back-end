package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.DeliveryPost;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryPostWriteDto {
    //    private User user;
    private String title;
    private String storeName;
    private String storeCategory;
    private Long delivery_fee;
    private String endTime;
    private Long done_num;
    private String location;
    private String content;
    private Long point;

    @Builder
    public DeliveryPostWriteDto(String title, String storeName, String storeCategory,
                             Long delivery_fee, String endTime,
                            Long done_num, String location, String content, Long point) {
        this.title = title;
        this.storeName = storeName;
        this.storeCategory = storeCategory;
        this.delivery_fee = delivery_fee;
        this.endTime = endTime;
        this.done_num = done_num;
        this.location = location;
        this.content = content;
        this.point = point;
    }

    public DeliveryPost toEntity() {
        return DeliveryPost.builder()
//                .user(user)
                .title(title)
                .storeName(storeName)
                .storeCategory(storeCategory)
                .delivery_fee(delivery_fee)
                .endTime(endTime)
                .done_num(done_num)
                .location(location)
                .content(content)
                .point(point)
                .build();
    }
}

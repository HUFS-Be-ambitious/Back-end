package hufs.capstone.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryPostUpdateDto {
    private String title;
    private String storeName;
    private Long delivery_fee;
    private String storeCategory;
    private String content;
    private Long done_num;
    private String endTime;
    private String location;
    private Long point;


    @Builder
    public void deliveryPostUpdateDto(String title, String storeName, String storeCategory,
                                      Long delivery_fee, String endTime, Long done_num,
                                       String location, Long point, String content) {
        this.title = title;
        this.storeName = storeName;
        this.storeCategory = storeCategory;
        this.delivery_fee = delivery_fee;
        this.endTime = endTime;
        this.done_num = done_num;
        this.location = location;
        this.point = point;
        this.content = content;
    }
}

package hufs.capstone.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeliveryPostUpdateDto {
    private String title;
    private String store_name;
    private Long delivery_fee;
    private String storeCategory;
    private String content;
    private Long done_num;
    private String endTime;
    private String location;
    private Long point;


    @Builder
    public void deliveryPostUpdateDto(String title, String store_name, String storeCategory,
                                      Long delivery_fee, Long done_num,
                                      String endTime, String location, Long point, String content) {
        this.title = title;
        this.store_name = store_name;
        this.storeCategory = storeCategory;
        this.delivery_fee = delivery_fee;
        this.done_num = done_num;
        this.endTime = endTime;
        this.location = location;
        this.point = point;
        this.content = content;
    }
}

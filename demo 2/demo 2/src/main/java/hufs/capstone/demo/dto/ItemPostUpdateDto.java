package hufs.capstone.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@NoArgsConstructor
public class ItemPostUpdateDto {
    private String title;
    private String item_name;
    private String itemCategory;
    private Long price;
    private Long delivery_fee;
    private String content;
    private Long done_num;
    private String endTime;
    private String location;
    private Long point;


    @Builder
    public void itemPostUpdateDto(String title, String item_name, String itemCategory,
                                  Long price, Long delivery_fee, String endTime, Long done_num,
                                   String location, Long point, String content) {
        this.title = title;
        this.item_name = item_name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.delivery_fee = delivery_fee;
        this.endTime = endTime;
        this.done_num = done_num;
        this.location = location;
        this.point = point;
        this.content = content;
    }

}

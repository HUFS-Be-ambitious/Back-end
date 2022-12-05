package hufs.capstone.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Data
@Table(name = "itempost")
public class ItemPost extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemPostSeq")
    private Long itemPostSeq;
    private String title;
    private String item_name;
    private String itemCategory;
    private Long price;
    private Long delivery_fee;
    private String endTime;
    private Integer present_num = 1;
    private Long done_num;
    private String host_id;
    private String host_account;
    private String location;
    private Long point;
    private String content;
    private String image_name;
    private String image_path;
    private String state = "진행중";
//    private User user;

    @OneToMany(mappedBy = "itemPost", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("commentId asc")
    private List<ItemComment> comments;

    @OneToMany(mappedBy = "itemPost", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<ItemGuestList> guests;

    @Builder
    public ItemPost(String title, String item_name, String itemCategory, Long price,
                    Long delivery_fee, String endTime,  Long done_num,
                    String host_id, String host_account, String location, Long point,
                    String content, String image_name, String image_path) {
        this.title = title;
        this.item_name = item_name;
        this.itemCategory = itemCategory;
        this.price = price;
        this.delivery_fee = delivery_fee;
        this.endTime = endTime;
        this.done_num = done_num;
        this.host_id = host_id;
        this.host_account = host_account;
        this.location = location;
        this.point = point;
        this.content = content;
        this.image_name = image_name;
        this.image_path = image_path;
    }

    public void update(String title, String item_name,String itemCategory,
                       Long price, Long delivery_fee, String endTime, Long done_num,
                       String location, Long point, String content,
                       String image_name, String image_path) {
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
        this.image_name = image_name;
        this.image_path = image_path;
    }
    public void updateState() {
        this.state = "진행완료";
    }

    public void addPresentNum() {
        this.present_num += 1;
    }

    public void subPresentNum() {
        this.present_num -= 1;
    }
}

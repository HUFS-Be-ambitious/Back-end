package hufs.capstone.demo.model;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Data
@Table(name = "deliverypost")
public class DeliveryPost extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryPostSeq")
    private Long deliveryPostSeq;
    private String title;
    private String store_name;
    private String storeCategory;
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

    @Builder
    public DeliveryPost(String title, String store_name, String storeCategory,
                    Long delivery_fee, Long done_num, String endTime,
                    String host_id, String host_account, String location, Long point,
                    String content, String image_name, String image_path) {
        this.title = title;
        this.store_name = store_name;
        this.storeCategory = storeCategory;
        this.delivery_fee = delivery_fee;
        this.done_num = done_num;
        this.endTime = endTime;
        this.host_id = host_id;
        this.host_account = host_account;
        this.location = location;
        this.point = point;
        this.content = content;
        this.image_name = image_name;
        this.image_path = image_path;
    }

    public void update(String title, String store_name, String storeCategory,
                       Long delivery_fee, Long done_num,
                       String endTime, String location, Long point, String content,
                       String image_name, String image_path) {
        this.title = title;
        this.store_name = store_name;
        this.storeCategory = storeCategory;
        this.delivery_fee = delivery_fee;
        this.done_num = done_num;
        this.endTime = endTime;
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

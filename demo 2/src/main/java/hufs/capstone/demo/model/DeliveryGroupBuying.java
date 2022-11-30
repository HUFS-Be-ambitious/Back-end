package hufs.capstone.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter @Setter
public class DeliveryGroupBuying {
    @Id
    @GeneratedValue
    @Column(name = "deliveryPostId")
    private Long id;

    @Column
    private String title;

    @Column
    private int presentNum;

    @Column
    private int doneNum;

    @Column
    private String state;

    public DeliveryGroupBuying(List<DeliveryGroupBuying> allDelivery) {
        this.doneNum = doneNum;
        this.presentNum = presentNum;
        this.state = state;
        this.title = title;
    }
}

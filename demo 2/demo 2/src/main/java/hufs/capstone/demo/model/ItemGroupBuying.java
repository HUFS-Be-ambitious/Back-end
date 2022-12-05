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
public class ItemGroupBuying {
    @Id
    @GeneratedValue
    @Column(name = "itemPostId")
    private Long id;

    @Column
    private String title;

    @Column
    private int presentNum;

    @Column
    private int doneNum;

    @Column
    private String state;

    public ItemGroupBuying(List<ItemGroupBuying> allItems) {
        this.doneNum = doneNum;
        this.state = state;
        this.presentNum = presentNum;
        this.title = title;
    }
}

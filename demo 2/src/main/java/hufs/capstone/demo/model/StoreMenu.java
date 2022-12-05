package hufs.capstone.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "storemenu")
@Entity
public class StoreMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;
    @ManyToOne
    @JoinColumn(name = "storeId")
    private StoreList storeList;
    private String foodName;
    private Long price;

    @Builder
    public StoreMenu(StoreList storeList, String foodName, Long price) {
        this.storeList = storeList;
        this.foodName = foodName;
        this.price = price;
    }
}

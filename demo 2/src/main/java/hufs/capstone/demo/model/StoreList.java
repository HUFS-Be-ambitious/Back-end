package hufs.capstone.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "storelist")
@Entity
public class StoreList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String storeName;

    private String storeLocation;

    private Long score;

    private String phoneNumber;

    private String description;

    private Long deliveryPrice;

    @OneToMany(mappedBy = "storeList", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<StoreMenu> menu;
}

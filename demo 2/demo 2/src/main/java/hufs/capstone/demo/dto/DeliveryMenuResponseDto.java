package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.StoreMenu;
import lombok.Getter;

@Getter
public class DeliveryMenuResponseDto {
    private Long listId;
    private String foodName;
    private Long price;
    private Long storeId;

    public DeliveryMenuResponseDto(StoreMenu menuList) {
        this.listId = menuList.getListId();
        this.foodName = menuList.getFoodName();
        this.price = menuList.getPrice();
        this.storeId = menuList.getStoreList().getStoreId();
    }
}

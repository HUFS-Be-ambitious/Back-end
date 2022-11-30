package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.DeliveryGroupBuying;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryGroupBuyingDto {
    private String title;
    private int presentNum;
    private int doneNum;
    private String state;

    public static DeliveryGroupBuyingDto of (DeliveryGroupBuying d) {
        return new DeliveryGroupBuyingDto(
                d.getTitle(),
                d.getPresentNum(),
                d.getDoneNum(),
                d.getState()
        );
    }

}

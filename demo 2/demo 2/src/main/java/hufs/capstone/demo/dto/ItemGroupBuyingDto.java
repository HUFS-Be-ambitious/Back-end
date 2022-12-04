package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.ItemGroupBuying;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemGroupBuyingDto {
    private String title;
    private int presentNum;
    private int doneNum;
    private String state;

    public static ItemGroupBuyingDto of (ItemGroupBuying i) {
        return new ItemGroupBuyingDto(
                i.getTitle(),
                i.getPresentNum(),
                i.getDoneNum(),
                i.getState()
        );
    }
}

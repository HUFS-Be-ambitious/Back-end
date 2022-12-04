package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.DeliveryGuestList;
import lombok.Getter;


@Getter
public class DeliveryGuestResponseDto {
    private Long listId;
    private String hostId;
    private String guestId;
    private String joinDate;

    private String nickname;
    private Long deliveryPostSeq;

    public DeliveryGuestResponseDto(DeliveryGuestList deliveryGuestList) {
        this.listId = deliveryGuestList.getListId();
        this.hostId = deliveryGuestList.getHostId();
        this.guestId = deliveryGuestList.getGuestId();
        this.joinDate = deliveryGuestList.getJoinDate();
//        this.nickname = deliveryGuestList.getMember().getNickname();
        this.deliveryPostSeq = deliveryGuestList.getDeliveryPost().getDeliveryPostSeq();
    }
}

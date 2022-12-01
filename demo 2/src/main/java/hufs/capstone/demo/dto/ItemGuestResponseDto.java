package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.ItemGuestList;
import lombok.Getter;


@Getter
public class ItemGuestResponseDto {
    private Long listId;
    private String hostId;
    private String guestId;
    private String joinDate;

    private String nickname;
    private Long itemPostSeq;

    public ItemGuestResponseDto(ItemGuestList itemGuestList) {
        this.listId = itemGuestList.getListId();
        this.hostId = itemGuestList.getHostId();
        this.guestId = itemGuestList.getGuestId();
        this.joinDate = itemGuestList.getJoinDate();
//        this.nickname = itemGuestList.getMember().getNickname();
        this.itemPostSeq = itemGuestList.getItemPost().getItemPostSeq();
    }
}

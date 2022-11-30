package cap.stone.dto;

import cap.stone.entity.BlackMemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackMemberDTO{
    Long id;
    Long memberId;
    int blackscore;

    public BlackMemberDTO(Long memberId, int blackscore){
        this.memberId = memberId;
        this.blackscore = blackscore;
    }

    public static BlackMemberDTO memberDTO(BlackMemberEntity blackMemberEntity){
        BlackMemberDTO blackMemberDTO = new BlackMemberDTO();
        blackMemberDTO.setBlackscore(blackMemberEntity.getBlackscore());
        return blackMemberDTO;
    }
}

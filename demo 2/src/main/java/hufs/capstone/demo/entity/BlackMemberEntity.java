package hufs.capstone.demo.entity;


import hufs.capstone.demo.dto.BlackMemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "black")
public class BlackMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "memberId", unique = true)
    private Long memberID;  //멤버 PK값
    @Column(name = "blackscore")
    private int blackscore; //매너점수

    public static BlackMemberEntity toSaveblack(BlackMemberDTO blackMemberDTO){
        BlackMemberEntity blackMember = new BlackMemberEntity();
        blackMember.setMemberID(blackMemberDTO.getMemberId());
        blackMember.setBlackscore(blackMemberDTO.getBlackscore());
        return blackMember;
    }

    public static BlackMemberEntity toUpdateBlack(BlackMemberDTO blackMemberDTO){
        BlackMemberEntity blackMember = BlackMemberEntity.toSaveblack(blackMemberDTO);
        blackMember.setMemberID(blackMemberDTO.getMemberId());
        return blackMember;
    }
}

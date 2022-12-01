package hufs.capstone.demo.entity;

import hufs.capstone.demo.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter @Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "login")
    private String login;
    @Column(length = 10, name = "username")
    private String username;  //이름
    @Column(name = "addr")
    private String addr; //주소
    @Column(length = 12,name = "phone", unique = true)
    private String phone; //전화번호
    @Column(length = 40, name = "mail", unique = true)
    @NotBlank
    private String mail; //메일 주소
    @Column(length = 1, name = "gender")
    private int gender; //남자 0, 여자1
    @Column(length = 12, name = "nick", unique = true)
    @NotBlank
    private String nick; //닉네임
    @Column(name = "point")
    private int point; //포인트
    @Column(name = "mScore")
    private int mScore; //매너점수
    @Column(name = "age")
    private int age; //나이
    @Column(length = 20, name = "schoolname")
    private String schoolname; //학교 이름
    @Column(name = "major")
    private String major; //전공
    @Column(name = "sId")
    private String sId; //학번
    @Column(length = 20, name = "password")
    private String password; //비밀번호
    @Column(name = "grade")
    private int grade;

    public static MemberEntity toSaveEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setLogin(memberDTO.getLogin());
        memberEntity.setMail(memberDTO.getMail());
        memberEntity.setPassword(memberDTO.getPassword());
        memberEntity.setPhone(memberDTO.getPhone());
        memberEntity.setSchoolname(memberDTO.getSchoolname());
        memberEntity.setUsername(memberDTO.getUsername());
        memberEntity.setAddr(memberDTO.getAddr());
        memberEntity.setGender(memberDTO.getGender());
        memberEntity.setNick(memberDTO.getNick());
        memberEntity.setPoint(memberDTO.getPoint());
        memberEntity.setMScore(memberDTO.getMScore());
        memberEntity.setAge(memberDTO.getAge());
        memberEntity.setMajor(memberDTO.getMajor());
        memberEntity.setSId(memberDTO.getSId());
        memberEntity.setGrade(memberDTO.getGrade());
        return memberEntity;
    }
    public static MemberEntity toUpdateEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
        memberEntity.setId(memberDTO.getId());
        return memberEntity;
    }
}

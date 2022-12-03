package hufs.capstone.demo.entity;

import hufs.capstone.demo.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "member")
public class Member {
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
    private String mail; //메일 주소
    @Column(length = 1, name = "gender")
    private int gender; //남자 0, 여자1
    @Column(length = 12, name = "nick", unique = true)
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

    public static Member toSaveEntity(MemberDTO memberDTO){
        Member member = new Member();
        member.setLogin(memberDTO.getLogin());
        member.setMail(memberDTO.getMail());
        member.setPassword(memberDTO.getPassword());
        member.setPhone(memberDTO.getPhone());
        member.setSchoolname(memberDTO.getSchoolname());
        member.setUsername(memberDTO.getUsername());
        member.setAddr(memberDTO.getAddr());
        member.setGender(memberDTO.getGender());
        member.setNick(memberDTO.getNick());
        member.setPoint(memberDTO.getPoint());
        member.setMScore(memberDTO.getMScore());
        member.setAge(memberDTO.getAge());
        member.setMajor(memberDTO.getMajor());
        member.setSId(memberDTO.getSId());
        member.setGrade(memberDTO.getGrade());
        return member;
    }
    public static Member toUpdateEntity(MemberDTO memberDTO){
        Member member = Member.toSaveEntity(memberDTO);
        member.setId(memberDTO.getId());
        return member;
    }
}

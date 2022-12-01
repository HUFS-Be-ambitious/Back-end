package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String login;
    private String mail;
    private String password;
    private String schoolname;
    private String phone;
    private String addr;
    private int gender;
    private int point;
    private int mScore;
    private int age;
    private String major;
    private String sId;
    private String username;
    private String nick;
    private int grade;

    public MemberDTO(String login, String mail, String password, String phone, String schoolname, String sId, String major,
                     String nick, String addr, String username, int gender, int point,
                     int mScore, int age, int grade) {
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.schoolname = schoolname;
        this.phone = phone;
        this.addr = addr;
        this.gender = gender;
        this.point = point;
        this.mScore = mScore;
        this.age = age;
        this.major = major;
        this.sId = sId;
        this.username = username;
        this.nick = nick;
        this.grade = grade;
    }

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setLogin(memberEntity.getLogin());
        memberDTO.setMail(memberEntity.getMail());
        memberDTO.setPassword(memberEntity.getPassword());
        memberDTO.setSchoolname(memberEntity.getSchoolname());
        memberDTO.setPhone(memberEntity.getPhone());
        memberDTO.setAddr(memberEntity.getAddr());
        memberDTO.setGender(memberEntity.getGender());
        memberDTO.setPoint(memberEntity.getPoint());
        memberDTO.setMScore(memberEntity.getMScore());
        memberDTO.setAge(memberEntity.getAge());
        memberDTO.setMajor(memberEntity.getMajor());
        memberDTO.setSId(memberEntity.getSId());
        memberDTO.setUsername(memberEntity.getUsername());
        memberDTO.setNick(memberEntity.getNick());
        memberDTO.setGrade(memberEntity.getGrade());
        return memberDTO;
    }
}

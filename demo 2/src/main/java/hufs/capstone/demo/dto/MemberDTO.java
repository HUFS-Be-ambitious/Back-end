package hufs.capstone.demo.dto;

import hufs.capstone.demo.entity.Member;
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

    public static MemberDTO toMemberDTO(Member member){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(member.getId());
        memberDTO.setLogin(member.getLogin());
        memberDTO.setMail(member.getMail());
        memberDTO.setPassword(member.getPassword());
        memberDTO.setSchoolname(member.getSchoolname());
        memberDTO.setPhone(member.getPhone());
        memberDTO.setAddr(member.getAddr());
        memberDTO.setGender(member.getGender());
        memberDTO.setPoint(member.getPoint());
        memberDTO.setMScore(member.getMScore());
        memberDTO.setAge(member.getAge());
        memberDTO.setMajor(member.getMajor());
        memberDTO.setSId(member.getSId());
        memberDTO.setUsername(member.getUsername());
        memberDTO.setNick(member.getNick());
        memberDTO.setGrade(member.getGrade());
        return memberDTO;
    }
}

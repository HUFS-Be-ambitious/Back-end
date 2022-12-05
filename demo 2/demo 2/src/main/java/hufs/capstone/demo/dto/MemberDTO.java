package hufs.capstone.demo.dto;

import hufs.capstone.demo.model.Member;
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
    private Integer gender;
    private Integer point;
    private Integer mScore;
    private Integer age;
    private String major;
    private String sId;
    private String username;
    private String nick;
    private Integer grade;

    public MemberDTO(String login, String mail, String password, String phone, String schoolname, String sId, String major,
                     String nick, String addr, String username, Integer gender, Integer point,
                     Integer mScore, Integer age, Integer grade) {
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

package com.project.capstoneproject.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_password")
    private String user_password;

    private String user_name;

    private String school;

    private String major;

    private String student_id;

    private String usermail;

    private Long mannerscore;

    private String nickname;

    private String phonenumber;

    private Long point;

    private Long age;

    private String gender;


    @Builder
    public Member(String userId, String user_password, String user_name, String school, String major,
                  String student_id, String usermail, Long mannerscore, String nickname, String phonenumber,
                  Long point, Long age, String gender) {
        this.userId = userId;
        this.user_password = user_password;
        this.user_name = user_name;
        this.school = school;
        this.major = major;
        this.student_id = student_id;
        this.usermail = usermail;
        this.mannerscore = mannerscore;
        this.nickname = nickname;
        this.phonenumber = phonenumber;
        this.point = point;
        this.age = age;
        this.gender = gender;
    }

}
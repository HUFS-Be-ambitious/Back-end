package com.project.capstoneproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "deliverycomment")
@Entity
public class DeliveryComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment;

    @CreatedDate
    private String createdDate;

    @LastModifiedDate
    private String modifiedDate;

    @ManyToOne
    @JoinColumn(name = "delivery_post_seq")
    private DeliveryPost deliveryPost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    public void update(String comment){
        this.comment = comment;
    }
}
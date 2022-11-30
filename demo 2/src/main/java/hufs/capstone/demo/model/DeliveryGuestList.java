package com.project.capstoneproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "deliveryguestlist")
@Entity
public class DeliveryGuestList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    private String hostId;
    private String guestId;
    @ManyToOne
    @JoinColumn(name = "deliveryPostSeq")
    private DeliveryPost deliveryPost;

    @CreatedDate
    private String joinDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));;

    @Builder
    public DeliveryGuestList(String hostId, String guestId, DeliveryPost deliveryPost) {
        this.hostId = hostId;
        this.guestId = guestId;
        this.deliveryPost = deliveryPost;
    }

}
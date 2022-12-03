package hufs.capstone.demo.model;

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
    @JoinColumn(name = "deliveryPostSeq")
    private DeliveryPost deliveryPost;

    @ManyToOne
    @JoinColumn(name = "login")
    private Member member;

    public void update(String comment){
        this.comment = comment;
    }
}
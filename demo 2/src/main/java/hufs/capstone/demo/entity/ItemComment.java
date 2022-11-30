package hufs.capstone.demo.entity;

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
@Table(name = "itemcomment")
@Entity
public class ItemComment {

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
    @JoinColumn(name = "itemPostSeq")
    private ItemPost itemPost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    public void update(String comment){
        this.comment = comment;
    }
}
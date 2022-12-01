package hufs.capstone.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "itemguestlist")
@Entity
public class ItemGuestList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;
    private String hostId;
    private String guestId;
    @ManyToOne
    @JoinColumn(name = "itemPostSeq")
    private ItemPost itemPost;

    @CreatedDate
    private String joinDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));

    @Builder
    public ItemGuestList(String hostId, String guestId, ItemPost itemPost) {
        this.hostId = hostId;
        this.guestId = guestId;
        this.itemPost = itemPost;
    }
}
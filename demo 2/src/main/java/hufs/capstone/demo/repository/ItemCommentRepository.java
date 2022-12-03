package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.ItemComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCommentRepository extends JpaRepository<ItemComment, Long> {
}

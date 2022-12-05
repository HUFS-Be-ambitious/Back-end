package hufs.capstone.demo.repository;


import hufs.capstone.demo.model.DeliveryComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryCommentRepository extends JpaRepository<DeliveryComment, Long> {
}

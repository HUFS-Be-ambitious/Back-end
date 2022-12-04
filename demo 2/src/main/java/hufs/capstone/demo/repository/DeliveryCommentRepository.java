package hufs.capstone.demo.repository;

import hufs.capstone.demo.entity.DeliveryComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryCommentRepository extends JpaRepository<DeliveryComment, Long> {
}

package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.DeliveryGroupBuying;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryGroupBuyingRepository extends JpaRepository<DeliveryGroupBuying, Long> {
    List<DeliveryGroupBuying> findAll();
    List<DeliveryGroupBuying> findDeliveryById(Long memberId);
}

package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.DeliveryPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryPostRepository extends JpaRepository<DeliveryPost,Long> {
    Page<DeliveryPost> findByTitleContaining(String searchKeyword, Pageable pageable);

    List<DeliveryPost> findTop4ByOrderByPointDesc();

    List<DeliveryPost> findTop4ByOrderByEndTime();

    Page<DeliveryPost> findByStoreCategory(String storeCategory, Pageable pageable);

    Page<DeliveryPost> findByStoreCategoryAndTitleContaining(String storeCategory, String keyword, Pageable pageable);
}

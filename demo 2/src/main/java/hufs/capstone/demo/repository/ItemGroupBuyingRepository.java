package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.ItemGroupBuying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemGroupBuyingRepository extends JpaRepository<ItemGroupBuying, Long> {
    List<ItemGroupBuying> findAll();
    List<ItemGroupBuying> findItemById(Long memberId);
}

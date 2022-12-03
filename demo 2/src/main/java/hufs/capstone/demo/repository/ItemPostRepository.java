package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.ItemPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPostRepository extends JpaRepository<ItemPost, Long> {
    Page<ItemPost> findByTitleContaining(String searchKeyword, Pageable pageable);

    List<ItemPost> findTop4ByOrderByPointDesc();

    List<ItemPost> findTop4ByOrderByEndTime();
    Page<ItemPost> findByItemCategory(String itemCategory, Pageable pageable);

    Page<ItemPost> findByItemCategoryAndTitleContaining(String itemCategory, String keyword, Pageable pageable);

}

package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.StoreMenu;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StoreMenuRepository extends JpaRepository<StoreMenu, Long> {

    @Query(value = "SELECT s.foodName FROM storemenu s " +
            "WHERE s.storeId =:storeId", nativeQuery = true)
    List<String> findByStoreId(@Param("storeId") Long storeId);
}

package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.StoreList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryStoreRepository extends JpaRepository<StoreList, Long> {
    @Query(value = "SELECT storeId FROM storelist s " +
            "WHERE s.storeName =:storeName", nativeQuery = true)
    Long findStoreIdByStoreName(String storeName);
}

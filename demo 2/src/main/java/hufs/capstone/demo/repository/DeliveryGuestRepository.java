package hufs.capstone.demo.repository;

import hufs.capstone.demo.entity.DeliveryGuestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryGuestRepository extends JpaRepository<DeliveryGuestList,Long> {
    boolean existsByGuestId(String guestId);

    @Query(value = "SELECT * FROM deliveryguestlist d " +
            "WHERE d.guestId =:guestId AND d.deliveryPostSeq =:deliveryPostSeq", nativeQuery = true)
    DeliveryGuestList findByGuestId(@Param("deliveryPostSeq") Long deliveryPostSeq, @Param("guestId") String guestId);

    @Query(value = "SELECT COUNT(d.listId) > 0 FROM deliveryguestlist d " +
            "WHERE d.guestId =:guestId AND d.deliveryPostSeq =:deliveryPostSeq", nativeQuery = true)
    Integer existsGuestId(@Param("deliveryPostSeq") Long deliveryPostSeq,@Param("guestId") String guestId);
}

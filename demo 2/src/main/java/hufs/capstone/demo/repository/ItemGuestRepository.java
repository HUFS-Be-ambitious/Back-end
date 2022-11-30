package hufs.capstone.demo.repository;

import hufs.capstone.demo.entity.ItemGuestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemGuestRepository extends JpaRepository<ItemGuestList, Long> {

    boolean existsByGuestId(String guestId);

    @Query(value = "SELECT * FROM itemguestlist i " +
            "WHERE i.guestId =:guestId AND i.itemPostSeq =:itemPostSeq", nativeQuery = true)
    ItemGuestList findByGuestId(@Param("itemPostSeq") Long itemPostSeq, @Param("guestId") String guestId);

    @Query(value = "SELECT COUNT(i.listId) > 0 FROM itemguestlist i " +
            "WHERE i.guestId =:guestId AND i.itemPostSeq =:itemPostSeq", nativeQuery = true)
    Integer existsGuestId(@Param("itemPostSeq") Long itemPostSeq,@Param("guestId") String guestId);
}

package hufs.capstone.demo.repository;

import hufs.capstone.demo.entity.BlackMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlackMemberRepository extends JpaRepository<BlackMemberEntity, Long> {
    Optional<BlackMemberEntity> findByMemberID(Long memberId);
    Optional<BlackMemberEntity> deleteByMemberID(Long memberId);
}

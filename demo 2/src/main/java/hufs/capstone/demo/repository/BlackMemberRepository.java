package cap.stone.repository;

import cap.stone.entity.BlackMemberEntity;
import cap.stone.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlackMemberRepository extends JpaRepository<BlackMemberEntity, Long> {
    Optional<BlackMemberEntity> findByMemberID(Long memberId);
    Optional<BlackMemberEntity> deleteByMemberID(Long memberId);
}

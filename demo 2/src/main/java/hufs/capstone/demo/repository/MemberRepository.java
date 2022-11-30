package hufs.capstone.demo.repository;

import hufs.capstone.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,String> {
//    @Query("SELECT * FROM USER WHERE nickname =?1")
//    User findByNickname(String nickname);
;}

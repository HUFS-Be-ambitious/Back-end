package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMail(String mail);
    Optional<Member> deleteByMailAndPassword(String mail, String password);
    Optional<Member> findByNick(String nick);
    Optional<Member> findByMailAndPassword(String mail, String password);
    Optional<Member> findByLoginAndPassword(String login, String password);
    Optional<Member> findByLogin(String login);
    @Query(value = "SELECT m.mScore FROM member m " +
            "WHERE m.login =:login", nativeQuery = true)
    Integer findMScoreByLogin(@Param("login") String login);

    String findAccountById(String login);
}

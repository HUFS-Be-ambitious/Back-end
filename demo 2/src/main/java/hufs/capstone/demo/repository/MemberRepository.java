package hufs.capstone.demo.repository;

import hufs.capstone.demo.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMail(String mail);
    Optional<Member> deleteByMailAndPassword(String mail, String password);
    Optional<Member> findByNick(String nick);
    Optional<Member> findByMailAndPassword(String mail, String password);
    Optional<Member> findByLoginAndPassword(String login, String password);
    Optional<Member> findByLogin(String login);
}

package hufs.capstone.demo.controller;

import hufs.capstone.demo.dto.MemberDTO;
import hufs.capstone.demo.dto.MemberLoginDTO;
import hufs.capstone.demo.model.Member;
import hufs.capstone.demo.repository.MemberRepository;
import hufs.capstone.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    //회원 가입
    @PostMapping("/member/login/add")
    public ResponseEntity<MemberDTO> addUser(@RequestBody MemberDTO memberDTO){
        if(memberService.save(memberDTO) != null){
            return new ResponseEntity<>(memberDTO, HttpStatus.CREATED);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //회원 삭제
    @DeleteMapping("/member/login/delete")
    public ResponseEntity<String> delUser(@RequestBody MemberLoginDTO dto, HttpSession session){
        if(session.getAttribute("id") == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            memberService.delete(dto.getLogin(), dto.getPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //회원 정보 수정
    @PostMapping("/member/mod/{login}")
    public ResponseEntity<MemberDTO> modUser(@RequestBody MemberDTO dto, HttpServletRequest req){
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("id");
        if(dto.getLogin().equals(login) == false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            if(memberService.update(dto) != null){
                return new ResponseEntity<>(dto, HttpStatus.OK);
        } else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @GetMapping("/member/find-all")
    public ResponseEntity<List<MemberDTO>> findAll(){
        List<MemberDTO> memberDTOList;
        memberDTOList = memberService.findAll();
        if(memberDTOList != null){
            return new ResponseEntity(memberDTOList,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //로그인 & 세션 부여
    @PostMapping("/member/login")
    public ResponseEntity<String> login(@RequestBody MemberLoginDTO ldto, HttpServletRequest req){
        MemberDTO dto = memberService.find(ldto.getLogin(), ldto.getPassword());
        if(dto != null){
            HttpSession session = req.getSession();
            session.setAttribute("id", ldto.getLogin());
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    //로그아웃 & 세션 제거
    @GetMapping("/member/login/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect: /login";
    }
    //매너점수 1점 추가
    @PostMapping("/member/mannerscore/{login}/increase")
    public ResponseEntity<Integer> increaseMannerScore(@PathVariable String login){
        MemberDTO dto = memberService.findByLogin(login);
        memberService.increaseMannerScore(dto,login);
        Integer newMscore = dto.getMScore();
        memberService.BlackController(dto, newMscore);
        /*int newMscore = dto.getMScore();
        newMscore++;
        Optional<Member> fbl = memberRepository.findByLogin(login);
        Member memberEntity = fbl.get();
        memberEntity.setMScore(newMscore);
        memberRepository.save(memberEntity);
        memberService.BlackController(dto, newMscore);

         */
        return new ResponseEntity<>(HttpStatus.OK); //페이지 어디로 redirect?
    }
    //매너 점수 1점 감소
    @PostMapping("/member/mannerscore/{login}/decrease")
    public ResponseEntity<String> decreaseMannerScore(@PathVariable String login){
        MemberDTO dto = memberService.findByLogin(login);
        memberService.decreaseMannerScore(dto, login);
        Integer newMscore = dto.getMScore();
        memberService.BlackController(dto, newMscore);
        return new ResponseEntity<>(HttpStatus.OK);
        /*MemberDTO dto = memberService.findByLogin(login);
        int newMscore = dto.getMScore();
        newMscore--;
        Optional<Member> fbl = memberRepository.findByLogin(login);
        Member memberEntity = fbl.get();
        memberEntity.setMScore(newMscore);
        memberRepository.save(memberEntity);
        memberService.BlackController(dto, newMscore);
        return new ResponseEntity<>(HttpStatus.OK);

         */
    }

    @GetMapping("/member/findby/{login}")
    public ResponseEntity<MemberDTO> findbylogin(@PathVariable String login) {
        MemberDTO dto = memberService.findByLogin(login);
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }
}
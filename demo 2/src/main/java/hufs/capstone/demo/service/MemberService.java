package hufs.capstone.demo.service;

import hufs.capstone.demo.dto.MemberDTO;
import hufs.capstone.demo.model.BlackMemberEntity;
import hufs.capstone.demo.model.Member;
import hufs.capstone.demo.repository.BlackMemberRepository;
import hufs.capstone.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final BlackMemberRepository blackMemberRepository;

    public Long save(MemberDTO memberDTO){
        try{
            Member member = Member.toSaveEntity(memberDTO);
            Long savedId = memberRepository.save(member).getId();
            System.out.println(savedId);
            return savedId;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public List<MemberDTO> findAll(){
        MemberDTO memberDTO = new MemberDTO();
        List<Member> memberList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(Member member: memberList){
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        return memberDTOList;
        }
        return memberDTOList;
    }
    public MemberDTO find(String login, String password){
        Optional<Member> entity = memberRepository.findByLoginAndPassword(login, password);
        System.out.println(entity);
        return entity.map(MemberDTO::toMemberDTO).orElse(null);
    }
    @Transactional
    public void delete(String mail, String password) {
       memberRepository.deleteByMailAndPassword(mail, password);
    }
    public String update(MemberDTO memberDTO){
        try{
            Optional<Member> fbm = memberRepository.findByLogin(memberDTO.getLogin());
            if(fbm.isEmpty()){
                throw new Exception("존재하지않음");
            }
            Member member = Member.toUpdateEntity(memberDTO);
            member.setId(fbm.get().getId());
            String savedId = memberRepository.save(member).getLogin();
            return savedId;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public Integer isSame(MemberDTO dto){
        String nick = dto.getNick();
        Optional<Member> byNick = memberRepository.findByNick(nick);
        if(byNick.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
    public String findNicknameById(Long id){
        Optional<Member>optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            Member member = optionalMemberEntity.get();
               MemberDTO memberDTO = MemberDTO.toMemberDTO(member);
            return memberDTO.getNick();
        } else{
            return null;
        }
    }

    public MemberDTO findMemberById(Long id){
        Optional<Member> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            Member member = optionalMemberEntity.get();
            MemberDTO memberDTO = MemberDTO.toMemberDTO(member);
            return memberDTO;
        } else{
            return null;
        }
    }
    public Long updateMemberScore(MemberDTO memberDTO, int mannerscore){
        try{
            Optional<Member> fbm = memberRepository.findByMail(memberDTO.getMail());
            if(fbm.isEmpty()){
                throw new Exception("존재하지않음");
            }
            Member member = fbm.get();
            member.setMScore(mannerscore);
            Long savedId = memberRepository.save(member).getId();
            return savedId;
        }catch (Exception e){
            System.out.println(e);
            return -1L;
        }
    }
    public void increaseMannerScore(MemberDTO dto, String login){
        dto = findByLogin(login);
        Integer newMscore = dto.getMScore();
        System.out.println(newMscore);
        newMscore++;
        Optional<Member> fbl = memberRepository.findByLogin(login);
        Member member = fbl.get();
        member.setMScore(newMscore);
        memberRepository.save(member);
    }
    public void decreaseMannerScore(MemberDTO dto, String login){
        dto = findByLogin(login);
        Integer newMscore = dto.getMScore();
        System.out.println(newMscore);
        newMscore--;
        Optional<Member> fbl = memberRepository.findByLogin(login);
        Member member = fbl.get();
        member.setMScore(newMscore);
        memberRepository.save(member);
    }
    @Transactional
    public void BlackController(MemberDTO memberDTO, Integer mannerScore){
        BlackMemberEntity blackMemberEntity = new BlackMemberEntity();
        Optional<Member> fbi = memberRepository.findById(memberDTO.getId());
        Member member = fbi.get();
        mannerScore = member.getMScore();
        Long blackId = member.getId();
        Optional<BlackMemberEntity> fbm = blackMemberRepository.findByMemberID(blackId);
        if(mannerScore < 25){
            if(fbm.isEmpty()){
                blackMemberEntity.setMemberID(blackId);
                blackMemberEntity.setBlackscore(mannerScore);
                blackMemberRepository.save(blackMemberEntity);
            }else {
                BlackMemberEntity blackMember = fbm.get();
                blackMember.setBlackscore(mannerScore);
                blackMemberRepository.save(blackMember);
            }
        }else{
            blackMemberRepository.deleteByMemberID(blackId);
        }
    }
    public MemberDTO findByLogin(String login){
        Optional<Member> optionalMemberEntity = memberRepository.findByLogin(login);
        if(optionalMemberEntity.isPresent()){
            Member member = optionalMemberEntity.get();
            MemberDTO memberDTO = MemberDTO.toMemberDTO(member);
            return memberDTO;
        } else{
            return null;
        }
    }

}

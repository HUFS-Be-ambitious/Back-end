package hufs.capstone.demo.service;

import hufs.capstone.demo.dto.MemberDTO;
import hufs.capstone.demo.entity.MemberEntity;
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
            MemberEntity memberEntity = MemberEntity.toSaveEntity(memberDTO);
            Long savedId = memberRepository.save(memberEntity).getId();
            System.out.println(savedId);
            return savedId;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public List<MemberDTO> findAll(){
        MemberDTO memberDTO = new MemberDTO();
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for(MemberEntity member: memberEntityList){
            memberDTOList.add(MemberDTO.toMemberDTO(member));
        return memberDTOList;
        }
        return memberDTOList;
    }
    public MemberDTO find(String login, String password){
        Optional<MemberEntity> entity = memberRepository.findByLoginAndPassword(login, password);
        System.out.println(entity);
        return entity.map(MemberDTO::toMemberDTO).orElse(null);
    }
    @Transactional
    public void delete(String mail, String password) {
       memberRepository.deleteByMailAndPassword(mail, password);
    }
    public String update(MemberDTO memberDTO){
        try{
            Optional<MemberEntity> fbm = memberRepository.findByLogin(memberDTO.getLogin());
            if(fbm.isEmpty()){
                throw new Exception("존재하지않음");
            }
            MemberEntity memberEntity = MemberEntity.toUpdateEntity(memberDTO);
            memberEntity.setId(fbm.get().getId());
            String savedId = memberRepository.save(memberEntity).getLogin();
            return savedId;
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    public int isSame(MemberDTO dto){
        String nick = dto.getNick();
        Optional<MemberEntity> byNick = memberRepository.findByNick(nick);
        if(byNick.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }
    public MemberDTO findByNick(String nick){
        Optional<MemberEntity>optionalMemberEntity = memberRepository.findByNick(nick);
        if(optionalMemberEntity.isPresent()){
            MemberEntity memberEntity = optionalMemberEntity.get();
            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            return memberDTO;
        } else{
            return null;
        }
    }

    public MemberDTO findById(Long id){
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if(optionalMemberEntity.isPresent()){
            MemberEntity memberEntity = optionalMemberEntity.get();
            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            return memberDTO;
        } else{
            return null;
        }
    }
    public Long updateMemberScore(MemberDTO memberDTO, int mannerscore){
        try{
            Optional<MemberEntity> fbm = memberRepository.findByMail(memberDTO.getMail());
            if(fbm.isEmpty()){
                throw new Exception("존재하지않음");
            }
            MemberEntity memberEntity = fbm.get();
            memberEntity.setMScore(mannerscore);
            Long savedId = memberRepository.save(memberEntity).getId();
            return savedId;
        }catch (Exception e){
            System.out.println(e);
            return -1L;
        }
    }
    @Transactional
    public void BlackController(MemberDTO memberDTO, int mannerScore){
        BlackMemberEntity blackMemberEntity = new BlackMemberEntity();
        Optional<MemberEntity> fbi = memberRepository.findById(memberDTO.getId());
        MemberEntity memberEntity = fbi.get();
        mannerScore = memberEntity.getMScore();
        Long blackId = memberEntity.getId();
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
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByLogin(login);
        if(optionalMemberEntity.isPresent()){
            MemberEntity memberEntity = optionalMemberEntity.get();
            MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
            return memberDTO;
        } else{
            return null;
        }
    }
}

package hufs.capstone.demo.service;

import hufs.capstone.demo.entity.ItemGuestList;
import hufs.capstone.demo.entity.ItemPost;
import hufs.capstone.demo.repository.ItemGuestRepository;
import hufs.capstone.demo.repository.ItemPostRepository;
import hufs.capstone.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemGuestService {
    private final ItemGuestRepository itemGuestRepository;
    private final MemberRepository memberRepository;
    private final ItemPostRepository itemPostRepository;


    @Transactional
    public void guestSave(Long itemPostSeq, String userId) {
        ItemPost itemPost = itemPostRepository.findById(itemPostSeq).orElseThrow(() ->
                new IllegalArgumentException("공구 참여 실패: 해당 게시글이 존재하지 않습니다." + itemPostSeq));

        String guestId = userId; //현재 사용중인 유저 아이디 사용해야함
        String hostId = itemPost.getHost_id();
        if (itemGuestRepository.existsGuestId(itemPostSeq, guestId) == 0) {
            ItemGuestList guest = new ItemGuestList(
                    hostId,
                    guestId,
                    itemPost
            );
            itemGuestRepository.save(guest);
            itemPost.addPresentNum();
        }
    }

    @Transactional
    public void guestDelete(Long itemPostSeq, String userId) {
        ItemPost itemPost = itemPostRepository.findById(itemPostSeq).orElseThrow(() ->
                new IllegalArgumentException("공구 참여 실패: 해당 게시글이 존재하지 않습니다." + itemPostSeq));
        ItemGuestList guestList = itemGuestRepository.findByGuestId(itemPostSeq, userId);
//                .orElseThrow(() ->
//                new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + userId));

        itemGuestRepository.delete(guestList);
        itemPost.subPresentNum();
    }
}

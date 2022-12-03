package hufs.capstone.demo.service;

import hufs.capstone.demo.model.DeliveryGuestList;
import hufs.capstone.demo.model.DeliveryPost;
import hufs.capstone.demo.repository.DeliveryGuestRepository;
import hufs.capstone.demo.repository.DeliveryPostRepository;
import hufs.capstone.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeliveryGuestService {
    private final DeliveryGuestRepository deliveryGuestRepository;
    private final MemberRepository memberRepository;
    private final DeliveryPostRepository deliveryPostRepository;


    @Transactional
    public void guestSave(Long deliveryPostSeq, String userId) {
        DeliveryPost deliveryPost = deliveryPostRepository.findById(deliveryPostSeq).orElseThrow(() ->
                new IllegalArgumentException("공구 참여 실패: 해당 게시글이 존재하지 않습니다." + deliveryPostSeq));

        String guestId = "ckdanr99"; //현재 사용중인 유저 아이디 사용해야함
        String hostId = deliveryPost.getHost_id();

//        if(deliveryGuestRepository.existsByGuestId(guestId)){}
        if (deliveryGuestRepository.existsGuestId(deliveryPostSeq, guestId) == 0) {
            DeliveryGuestList guest = new DeliveryGuestList(
                    hostId,
                    guestId,
                    deliveryPost
            );
            deliveryGuestRepository.save(guest);

        }
    }

        @Transactional
        public void guestDelete(Long deliveryPostSeq, String userId) {
            DeliveryPost deliveryPost = deliveryPostRepository.findById(deliveryPostSeq).orElseThrow(() ->
                    new IllegalArgumentException("공구 참여 실패: 해당 게시글이 존재하지 않습니다." + deliveryPostSeq));
            DeliveryGuestList guestList = deliveryGuestRepository.findByGuestId(deliveryPostSeq, userId);
//                .orElseThrow(() ->
//                new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + userId));

            deliveryGuestRepository.delete(guestList);
            deliveryPost.subPresentNum();
        }
}

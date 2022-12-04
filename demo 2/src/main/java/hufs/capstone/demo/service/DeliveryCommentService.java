package hufs.capstone.demo.service;

import hufs.capstone.demo.dto.DeliveryCommentRequestDto;
import hufs.capstone.demo.entity.DeliveryComment;
import hufs.capstone.demo.entity.DeliveryPost;
import hufs.capstone.demo.repository.DeliveryCommentRepository;
import hufs.capstone.demo.repository.DeliveryPostRepository;
import hufs.capstone.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeliveryCommentService {
    private final DeliveryCommentRepository deliveryCommentRepository;
    private final MemberRepository memberRepository;
    private final DeliveryPostRepository deliveryPostRepository;


    @Transactional
    public void commentWrite(String userId, Long deliveryPostSeq, DeliveryCommentRequestDto commentDto) {
//        User user = userRepository.findByUserId(userId);
        DeliveryPost deliveryPost = deliveryPostRepository.findById(deliveryPostSeq).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + deliveryPostSeq));

//        commentDto.setMember(member);
        commentDto.setDeliveryPost(deliveryPost);

        DeliveryComment comment = commentDto.toEntity();
        deliveryCommentRepository.save(comment);
    }


    @Transactional
    public void update(Long commentId, DeliveryCommentRequestDto commentDto) {
        DeliveryComment comment = deliveryCommentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + commentId));

        comment.update(commentDto.getComment());
    }


    @Transactional
    public void delete(Long commentId) {
        DeliveryComment comment = deliveryCommentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + commentId));

        deliveryCommentRepository.delete(comment);
    }
}

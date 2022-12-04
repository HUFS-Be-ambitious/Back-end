package hufs.capstone.demo.service;

import hufs.capstone.demo.dto.ItemCommentRequestDto;
import hufs.capstone.demo.model.ItemComment;
import hufs.capstone.demo.model.ItemPost;
import hufs.capstone.demo.repository.ItemCommentRepository;
import hufs.capstone.demo.repository.ItemPostRepository;
import hufs.capstone.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ItemCommentService {
    private final ItemCommentRepository itemCommentRepository;
    private final MemberRepository memberRepository;
    private final ItemPostRepository itemPostRepository;


    @Transactional
    public void commentWrite(String userId, Long itemPostSeq, ItemCommentRequestDto commentDto) {
//        User user = userRepository.findByUserId(userId);
        ItemPost itemPost = itemPostRepository.findById(itemPostSeq).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패: 해당 게시글이 존재하지 않습니다." + itemPostSeq));

//        commentDto.setMember(member);
        commentDto.setItemPost(itemPost);

        ItemComment comment = commentDto.toEntity();
        itemCommentRepository.save(comment);
    }


    @Transactional
    public void update(Long commentId, ItemCommentRequestDto commentDto) {
        ItemComment comment = itemCommentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + commentId));

        comment.update(commentDto.getComment());
    }


    @Transactional
    public void delete(Long commentId) {
        ItemComment comment = itemCommentRepository.findById(commentId).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + commentId));

        itemCommentRepository.delete(comment);
    }
}

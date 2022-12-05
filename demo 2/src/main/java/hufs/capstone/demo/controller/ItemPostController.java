package hufs.capstone.demo.controller;

import hufs.capstone.demo.service.ItemGuestService;
import hufs.capstone.demo.service.ItemPostService;
import hufs.capstone.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
public class ItemPostController {
    private final ItemPostService itemPostService;
    private final ItemGuestService itemGuestService;
//    private final MemberService memberService;

    //물건


    @PostMapping("/itempost/write")
    public void itemPostWrite(@RequestPart ItemPostWriteDto writeDto, @RequestPart MultipartFile file) throws Exception {
        itemPostService.write(writeDto, file); //session 처리 필요
    }


    @GetMapping("/itempost/list")
    public Page<ItemPostResponseDto> itemPostViewList(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                                      @RequestParam(required = false, defaultValue = "itemPostSeq",value = "orderby") String orderCriteria,
                                                      Pageable pageable,
                                                      Model model) {

        Page<ItemPostResponseDto> itemPostList =
                itemPostService.getAllList(pageable, pageNo, orderCriteria);

        model.addAttribute("itemPostList", itemPostList);

        return itemPostList;
    }

    // 카테고리별 조회
    // /{category_name}/page={pageNo}&orderby={orderCriteria}
    @GetMapping("/itempost/list/{itemCategory}")
    public Page<ItemPostResponseDto> itemPostCategoryList(@PathVariable(required = false) String itemCategory,
                                   @RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                   @RequestParam(required = false, defaultValue = "itemPostSeq",value = "orderby") String orderCriteria,
                                  Pageable pageable,
                                   Model model) {

        Page<ItemPostResponseDto> itemPostList =
                itemPostService.getPageList(pageable, pageNo, itemCategory, orderCriteria);

        model.addAttribute("itemPostList", itemPostList);

        return itemPostList;
    }

    // 글 검색 페이지
    // /{itemCategory}/search/keyword={keyword}&page={pageNo}&orderby={orderCriteria}
    @GetMapping("/itempost/list/search/{itemCategory}")
    public Page<ItemPostResponseDto> searchByCategory(@PathVariable("itemCategory") String itemCategory,
                                   @RequestParam("keyword") String keyword,
                                   @RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                   @RequestParam(required = false, defaultValue = "itemPostSeq", value = "orderby") String orderCriteria,
                                   Pageable pageable,
                                   Model model){


        Page<ItemPostResponseDto> itemPostList =
                itemPostService.searchPageList(pageable, pageNo, keyword, itemCategory, orderCriteria);

        model.addAttribute("itemPostList",itemPostList);
        return itemPostList;
    }

    //개별 조회
    @GetMapping("/itempost/view/{itemPostSeq}")
    public String itemPostViewDetail(@PathVariable Long itemPostSeq, Model model) {
        ItemPostDto itemPostDto = itemPostService.viewDetail(itemPostSeq);
        List<ItemCommentResponseDto> comments = itemPostDto.getComments();
        model.addAttribute("itemPost", itemPostDto);
        model.addAttribute("comments", comments);
        return "itempostview";
    }

    //공구 참여 등록
    @GetMapping("/itempost/view/{itemPostSeq}/register")
    public void itemPostGuestRegister(@PathVariable Long itemPostSeq, String userId) {
        itemGuestService.guestSave(itemPostSeq, userId);
    }

    //공구 참여 취소
    @DeleteMapping("/itempost/view/{itemPostSeq}/register")
    public void itemPostGuestDelete(@PathVariable Long itemPostSeq, String userId) {
        itemGuestService.guestDelete(itemPostSeq, userId);
    }


    //게시물 삭제
    @GetMapping("/itempost/delete")
    public String itemPostDelete(Long itemPostSeq) {

        itemPostService.delete(itemPostSeq);
        return "redirect:/itempost/list";
    }

    //게시물 수정
    @PutMapping("/itempost/update/{itemPostSeq}")
    public void itemPostUpdate(@PathVariable Long itemPostSeq, @RequestPart ItemPostUpdateDto updateDto, MultipartFile file) throws Exception {
        itemPostService.update(itemPostSeq, updateDto, file);
    }

    //공구 마감
    @PutMapping("/itempost/view/{itemPostSeq}/done")
    public void itemPostStateUpdate(@PathVariable Long itemPostSeq) {
        itemPostService.updateState(itemPostSeq);
    }

    /* 글 상세보기 */
//    @GetMapping("/posts/read/{id}")
//    public String read(@PathVariable Long id, @LoginUser UserSessionDto user, Model model) {
//        PostsResponseDto dto = postsService.findById(id);
//        List<CommentResponseDto> comments = dto.getComments();
//
//        /* 댓글 관련 */
//        if (comments != null && !comments.isEmpty()) {
//            model.addAttribute("comments", comments);
//        }
//
//        /* 사용자 관련 */
//        if (user != null) {
//            model.addAttribute("user", user.getNickname());
//
//            /*게시글 작성자 본인인지 확인*/
//            if (dto.getUserId().equals(user.getId())) {
//                model.addAttribute("writer", true);
//            }
//        }
//        postsService.updateView(id); // views ++
//        model.addAttribute("posts", dto);
//        return "posts/posts-read";
//    }
}

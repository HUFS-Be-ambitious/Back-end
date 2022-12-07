package hufs.capstone.demo.controller;

import hufs.capstone.demo.dto.DeliveryPostDto;
import hufs.capstone.demo.dto.DeliveryPostResponseDto;
import hufs.capstone.demo.dto.DeliveryPostUpdateDto;
import hufs.capstone.demo.dto.DeliveryPostWriteDto;
import hufs.capstone.demo.service.DeliveryGuestService;
import hufs.capstone.demo.service.DeliveryPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class DeliveryPostController {
    private final DeliveryPostService deliveryPostService;
    private final DeliveryGuestService deliveryGuestService;
//    private final MemberService memberService;

    HttpSession session;
//    private final MemberService memberService;
    
    
//    @PostMapping("/deliverypost/write")
//    public void deliveryPostWrite(@RequestPart DeliveryPostWriteDto writeDto, @RequestPart MultipartFile file) throws Exception {
//        String userId = (String)session.getAttribute("id");
//        deliveryPostService.write(writeDto, userId, file); //session 처리 필요
//    }

    @PostMapping("/deliverypost/write")
    public void deliveryPostWrite(@RequestPart DeliveryPostWriteDto writeDto, @RequestParam("file") MultipartFile file, HttpSession session) throws Exception{
        String userId = (String)session.getAttribute("id");
//        String userId = "ckdanr98";
        deliveryPostService.write(writeDto, userId, file); //session 처리 필요
    }


    //전체 리스트 조회
    @GetMapping("/deliverypost/list")
    public Page<DeliveryPostResponseDto> deliveryPostViewList(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                                              @RequestParam(required = false, defaultValue = "deliveryPostSeq",value = "orderby") String orderCriteria,
                                                              Pageable pageable,
                                                              Model model) {

        Page<DeliveryPostResponseDto> deliveryPostList =
                deliveryPostService.getAllList(pageable, pageNo, orderCriteria);


        model.addAttribute("deliveryPostList", deliveryPostList);

        return deliveryPostList;
    }

    // 카테고리별 조회
    // /{category_name}/page={pageNo}&orderby={orderCriteria}
    @GetMapping("/deliverypost/list/{storeCategory}")
    public Page<DeliveryPostResponseDto> deliveryPostCategoryList(@PathVariable(required = false) String storeCategory,
                                                          @RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                                          @RequestParam(required = false, defaultValue = "deliveryPostSeq",value = "orderby") String orderCriteria,
                                                          Pageable pageable,
                                                          Model model) {

        Page<DeliveryPostResponseDto> deliveryPostList =
                deliveryPostService.getPageList(pageable, pageNo, storeCategory, orderCriteria);

        model.addAttribute("deliveryPostList", deliveryPostList);

        return deliveryPostList;
    }

    // 글 검색 페이지
    // /{storeCategory}/search/keyword={keyword}&page={pageNo}&orderby={orderCriteria}
    @GetMapping("/deliverypost/list/search/{storeCategory}")
    public Page<DeliveryPostResponseDto> searchByCategory(@PathVariable("storeCategory") String storeCategory,
                                                      @RequestParam(required = false, defaultValue = "", value = "keyword") String keyword,
                                                      @RequestParam(required = false, defaultValue = "0", value = "page") int pageNo,
                                                      @RequestParam(required = false, defaultValue = "deliveryPostSeq", value = "orderby") String orderCriteria,
                                                      Pageable pageable,
                                                      Model model){


        Page<DeliveryPostResponseDto> deliveryPostList =
                deliveryPostService.searchPageList(pageable, pageNo, keyword, storeCategory, orderCriteria);

        model.addAttribute("deliveryPostList",deliveryPostList);
        return deliveryPostList;
    }

    ////개별 조회
    @GetMapping("/deliverypost/view/{deliveryPostSeq}")
    public DeliveryPostDto deliveryPostViewDetail(@PathVariable Long deliveryPostSeq, Model model) {
        DeliveryPostDto deliveryPostDto = deliveryPostService.viewDetail(deliveryPostSeq);
        model.addAttribute("deliveryPost", deliveryPostDto);
        return deliveryPostDto;
    }
    //공구 참여 등록
    @GetMapping("/deliverypost/view/{deliveryPostSeq}/register")
    public void deliveryPostGuestRegister(@PathVariable Long deliveryPostSeq, HttpSession session) {
        String userId = (String)session.getAttribute("id");
        deliveryGuestService.guestSave(deliveryPostSeq, userId);
    }

    //공구 참여 취소
    @DeleteMapping("/deliverypost/view/{deliveryPostSeq}/register")
    public void deliveryPostGuestDelete(@PathVariable Long deliveryPostSeq, String userId) {
        deliveryGuestService.guestDelete(deliveryPostSeq, userId);
    }

    //게시물 삭제
    @GetMapping("/deliverypost/delete")
    public String deliveryPostDelete(Long deliveryPostSeq) {

        deliveryPostService.delete(deliveryPostSeq);
        return "redirect:/deliverypost/list";
    }

    //게시물 수정
    @PutMapping("/deliverypost/update/{deliveryPostSeq}")
    public void deliveryPostUpdate(@PathVariable Long deliveryPostSeq, @RequestPart DeliveryPostUpdateDto updateDto, MultipartFile file) throws Exception {
        deliveryPostService.update(deliveryPostSeq, updateDto, file);
    }
    
    //공구 마감
    @PutMapping("/deliverypost/view/{deliveryPostSeq}/done")
    public void deliveryPostStateUpdate(@PathVariable Long deliveryPostSeq) {
        deliveryPostService.updateState(deliveryPostSeq);
    }

}

package hufs.capstone.demo.controller;

import hufs.capstone.demo.model.DeliveryPost;
import hufs.capstone.demo.model.ItemPost;
import hufs.capstone.demo.service.DeliveryPostService;
import hufs.capstone.demo.service.ItemPostService;
import hufs.capstone.demo.service.MainPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MainPostController {

    private final ItemPostService itemPostService;
    private final DeliveryPostService deliveryPostService;
    private final MainPostService mainPostService;


    //프리미엄 공구
    @GetMapping("/main")
    public String mainPostViewList(Model model) {

        //프리미엄 물품 리스트
        List<ItemPost> itemPointList = mainPostService.viewItemPointList();
        //프리미엄 배달 리스트
        List<DeliveryPost> deliveryPointList = mainPostService.viewDeliveryPointList();
        //마감임박 상품 리스트(물품)
        List<ItemPost> itemDeadlineList = mainPostService.viewItemDeadlineList();
        //마감임박 상품 리스트(배달)
        List<DeliveryPost> deliveryDeadlineList = mainPostService.viewDeliveryDeadlineList();

        model.addAttribute("premiumItemPost",itemPointList);
        model.addAttribute("premiumDeliveryPost",deliveryPointList);
        model.addAttribute("deadlineItemPost",itemDeadlineList);
        model.addAttribute("deadlineDeliveryPost",deliveryDeadlineList);

        return "main";
    }

}

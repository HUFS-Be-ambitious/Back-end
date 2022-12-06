package hufs.capstone.demo.controller;

import hufs.capstone.demo.model.ItemGroupBuying;
import hufs.capstone.demo.service.ItemGroupBuyingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class ItemGroupBuyingController {
    private final ItemGroupBuyingService itemGroupBuyingService;

    @GetMapping("/api/item/findAll")
    public ItemGroupBuying findAllItems() {
        return new ItemGroupBuying(itemGroupBuyingService.findAllItems());
    }

    @GetMapping("/api/item/{memberId}/{state}")
    public ItemGroupBuying findItemByMemberId(@PathVariable("memberId") Long memberId,
                                              @PathVariable("state") Long state) {
        return new ItemGroupBuying(itemGroupBuyingService.findItemByMemberId(memberId));
    }


}

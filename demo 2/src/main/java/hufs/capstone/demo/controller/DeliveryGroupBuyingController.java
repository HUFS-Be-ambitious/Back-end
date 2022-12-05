package hufs.capstone.demo.controller;

import hufs.capstone.demo.model.DeliveryGroupBuying;
import hufs.capstone.demo.service.DeliveryGroupBuyingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin("*")
public class DeliveryGroupBuyingController {
    private DeliveryGroupBuyingService deliveryGroupBuyingService;

    @GetMapping("/api/delivery/findAll")
    public DeliveryGroupBuying findAllDelivery() {
        return new DeliveryGroupBuying(deliveryGroupBuyingService.findAllDelivery());
    }


    @GetMapping("api/delivery/{memberId}/{state}")
    public DeliveryGroupBuying findDeliveryByMemberId(@PathVariable("memberId") Long memberId,
                                                      @PathVariable("state") Long state) {

        return new DeliveryGroupBuying(deliveryGroupBuyingService.findDeliveryByMemberId(memberId));
    }
}

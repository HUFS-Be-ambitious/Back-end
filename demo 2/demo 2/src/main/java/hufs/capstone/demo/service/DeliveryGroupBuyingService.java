package hufs.capstone.demo.service;

import hufs.capstone.demo.model.DeliveryGroupBuying;
import hufs.capstone.demo.repository.DeliveryGroupBuyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryGroupBuyingService {
    @Autowired
    private DeliveryGroupBuyingRepository deliveryGroupBuyingRepository;

    public List<DeliveryGroupBuying> findAllDelivery() {
        return deliveryGroupBuyingRepository.findAll();
    }

    public List<DeliveryGroupBuying> findDeliveryByMemberId(Long memberId) {
        return deliveryGroupBuyingRepository.findDeliveryById(memberId);
    }


}

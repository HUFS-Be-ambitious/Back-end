package hufs.capstone.demo.service;

import hufs.capstone.demo.model.ItemGroupBuying;
import hufs.capstone.demo.repository.ItemGroupBuyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemGroupBuyingService {

    @Autowired
    private ItemGroupBuyingRepository itemGroupBuyingRepository;

    public List<ItemGroupBuying> findAllItems(){
        return itemGroupBuyingRepository.findAll();
    }

    public List<ItemGroupBuying> findItemByMemberId(Long memberId) {
        return itemGroupBuyingRepository.findItemById(memberId);
    }
}

package hufs.capstone.demo.service;


import hufs.capstone.demo.entity.DeliveryPost;
import hufs.capstone.demo.entity.ItemPost;
import hufs.capstone.demo.repository.DeliveryPostRepository;
import hufs.capstone.demo.repository.ItemPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MainPostService {

    private final ItemPostRepository itemPostRepository;
    private final DeliveryPostRepository deliveryPostRepository;

    //메인에 띄워줄 리스트(포인트 내림차순으로 4개)
    @Transactional(readOnly = true)
    public List<ItemPost> viewItemPointList() {
        return itemPostRepository.findTop4ByOrderByPointDesc();
    }
    @Transactional(readOnly = true)
    public List<DeliveryPost> viewDeliveryPointList() {

        return deliveryPostRepository.findTop4ByOrderByPointDesc();
    }

    @Transactional(readOnly = true)
    public List<ItemPost> viewItemDeadlineList() {

        return itemPostRepository.findTop4ByOrderByEndTime();
    }

    @Transactional(readOnly = true)
    public List<DeliveryPost> viewDeliveryDeadlineList() {

        return deliveryPostRepository.findTop4ByOrderByEndTime();
    }


}

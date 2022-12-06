package hufs.capstone.demo.service;

import hufs.capstone.demo.dto.DeliveryPostDto;
import hufs.capstone.demo.dto.DeliveryPostUpdateDto;
import hufs.capstone.demo.dto.DeliveryPostWriteDto;
import hufs.capstone.demo.dto.DeliveryPostResponseDto;
import hufs.capstone.demo.model.DeliveryPost;
import hufs.capstone.demo.repository.DeliveryPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DeliveryPostService {

    private final DeliveryPostRepository deliveryPostRepository;

    //게시물 작성
    @Transactional
    public void write(DeliveryPostWriteDto writeDto, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\demo 2\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID(); //식별자(랜덤이름 생성)

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        String image_name = fileName;
        String image_path = "/files/" + fileName;
        String host_id = "ckdanr98";    //session 아이디가 들어가야됨
        String host_account = "10010956037840"; //session 아이디에 해당되는 계좌가 들어가야 됨

        DeliveryPost deliveryPost = new DeliveryPost(
                writeDto.getTitle(),
                writeDto.getStore_name(),
                writeDto.getStoreCategory(),
                writeDto.getDelivery_fee(),
                writeDto.getDone_num(),
                writeDto.getEndTime(),
                host_id,
                host_account,
                writeDto.getLocation(),
                writeDto.getPoint(), //로직 처리 필요
                writeDto.getContent(),
                image_name,
                image_path
        );


        deliveryPostRepository.save(deliveryPost);
    }
    public Page<DeliveryPostResponseDto> getAllList(Pageable pageable, int pageNo, String orderCriteria){

        if (orderCriteria.equals("latest")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "deliveryPostSeq"));
        } else if (orderCriteria.equals("deadline")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "endTime"));
        } else {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, orderCriteria));
        }

        /* category_name에 해당하는 post 페이지 객체 반환 */
        Page<DeliveryPost> page = deliveryPostRepository.findAll(pageable);
        Page<DeliveryPostResponseDto> deliveryPostList = page.map(
                deliveryPost -> new DeliveryPostResponseDto(
                        deliveryPost.getDeliveryPostSeq(),
                        deliveryPost.getTitle(),
                        deliveryPost.getHost_id(),
                        deliveryPost.getImage_path()
                )
        );

        return deliveryPostList;
    }
    public Page<DeliveryPostResponseDto> getPageList(Pageable pageable, int pageNo,
                                                 String storeCategory, String orderCriteria) {

        /* 넘겨받은 orderCriteria 를 이용해 내림차순하여 Pageable 객체 반환 */
        if (orderCriteria.equals("latest")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "deliveryPostSeq"));
        } else if (orderCriteria.equals("deadline")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "endTime"));
        } else {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, orderCriteria));
        }

        /* category_name에 해당하는 post 페이지 객체 반환 */
        Page<DeliveryPost> page = deliveryPostRepository.findByStoreCategory(storeCategory, pageable);


        /* Dto로 변환 */
        Page<DeliveryPostResponseDto> deliveryPostList = page.map(
                deliveryPost -> new DeliveryPostResponseDto(
                        deliveryPost.getDeliveryPostSeq(),
                        deliveryPost.getTitle(),
                        deliveryPost.getHost_id(),
                        deliveryPost.getImage_path()
                )
        );

        return deliveryPostList;
    }

    public Page<DeliveryPostResponseDto> searchPageList(Pageable pageable, int pageNo, String keyword, String storeCategory, String orderCriteria) {

        /* 넘겨받은 orderCriteria 를 이용해 내림차순하여 Pageable 객체 반환 */
        if (orderCriteria.equals("latest")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "deliveryPostSeq"));
        } else if (orderCriteria.equals("deadline")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "endTime"));
        } else {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, orderCriteria));
        };

        /* storeCategory에 해당하면서 keyword를 포함하는 post 페이지 객체 반환 */
        Page<DeliveryPost> page = deliveryPostRepository.findByStoreCategoryAndTitleContaining(storeCategory, keyword, pageable);

        Page<DeliveryPostResponseDto> deliveryPostList = page.map(
                deliveryPost -> new DeliveryPostResponseDto(
                        deliveryPost.getDeliveryPostSeq(),
                        deliveryPost.getTitle(),
                        deliveryPost.getHost_id(),
                        deliveryPost.getImage_path()
                )
        );

        return deliveryPostList;
    }

    //개별 조회
    @Transactional(readOnly = true)
    public DeliveryPostDto viewDetail(Long deliveryPostSeq) {
        DeliveryPost deliveryPost = deliveryPostRepository.findById(deliveryPostSeq).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new DeliveryPostDto(deliveryPost);
    }

    // 게시글 삭제

    @Transactional
    public void delete(Long deliveryPostSeq) {
        deliveryPostRepository.deleteById(deliveryPostSeq);
    }

    @Transactional
    public void update(Long deliveryPostSeq, DeliveryPostUpdateDto updateDto, MultipartFile file) throws Exception {
        DeliveryPost deliveryPostTemp = deliveryPostRepository.findById(deliveryPostSeq).
                orElseThrow(()
                        -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID(); //식별자(랜덤이름 생성)

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        String image_name = fileName;
        String image_path = "/files/" + fileName;


        deliveryPostTemp.update(updateDto.getTitle(), updateDto.getStore_name(), updateDto.getStoreCategory(),
                updateDto.getDelivery_fee(),
                updateDto.getDone_num(), updateDto.getEndTime(), updateDto.getLocation(), updateDto.getPoint(),
                updateDto.getContent(), image_name, image_path);
    }
    @Transactional
    public void updateState(Long deliveryPostSeq) {
        DeliveryPost deliveryPost = deliveryPostRepository.findById(deliveryPostSeq).
                orElseThrow(()
                        -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        deliveryPost.updateState();
    }
}
    



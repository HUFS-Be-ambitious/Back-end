package hufs.capstone.demo.service;

import hufs.capstone.demo.dto.ItemPostDto;
import hufs.capstone.demo.dto.ItemPostResponseDto;
import hufs.capstone.demo.dto.ItemPostUpdateDto;
import hufs.capstone.demo.dto.ItemPostWriteDto;
import hufs.capstone.demo.entity.ItemPost;
import hufs.capstone.demo.repository.ItemPostRepository;
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
public class ItemPostService {

    private final ItemPostRepository itemPostRepository;

    //게시물 작성
    @Transactional
    public void write(ItemPostWriteDto writeDto, MultipartFile file) throws Exception {
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID(); //식별자(랜덤이름 생성)

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        String image_name = fileName;
        String image_path = "/files/" + fileName;
        String host_id = "ckdanr98";    //session 아이디가 들어가야됨
        String host_account = "10010956037840"; //session 아이디에 해당되는 계좌가 들어가야 됨

        ItemPost itemPost = new ItemPost(
                writeDto.getTitle(),
                writeDto.getItem_name(),
                writeDto.getItemCategory(),
                writeDto.getPrice(),
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

        itemPostRepository.save(itemPost);
    }

    public Page<ItemPostResponseDto> getAllList(Pageable pageable, int pageNo, String orderCriteria){

        if(orderCriteria.equals("highPrice")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "price"));
        } else if (orderCriteria.equals("lowPrice")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "price"));
        } else if (orderCriteria.equals("latest")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "itemPostSeq"));
        } else if (orderCriteria.equals("deadline")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "endTime"));
        } else {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, orderCriteria));
        }

        /* category_name에 해당하는 post 페이지 객체 반환 */
        Page<ItemPost> page = itemPostRepository.findAll(pageable);
        Page<ItemPostResponseDto> itemPostList = page.map(
                itemPost -> new ItemPostResponseDto(
                        itemPost.getItemPostSeq(),
                        itemPost.getTitle(),
                        itemPost.getHost_id(),
                        itemPost.getImage_path(),
                        itemPost.getPrice()
                )
        );

        return itemPostList;
    }
    public Page<ItemPostResponseDto> getPageList(Pageable pageable, int pageNo,
                                                     String itemCategory, String orderCriteria) {

        /* 넘겨받은 orderCriteria 를 이용해 내림차순하여 Pageable 객체 반환 */
        if(orderCriteria.equals("highPrice")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "price"));
        } else if (orderCriteria.equals("lowPrice")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "price"));
        } else if (orderCriteria.equals("latest")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "itemPostSeq"));
        } else if (orderCriteria.equals("deadline")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "endTime"));
        } else {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, orderCriteria));
        }

        /* category_name에 해당하는 post 페이지 객체 반환 */
        Page<ItemPost> page = itemPostRepository.findByItemCategory(itemCategory, pageable);


        /* Dto로 변환 */
        Page<ItemPostResponseDto> itemPostList = page.map(
                itemPost -> new ItemPostResponseDto(
                        itemPost.getItemPostSeq(),
                        itemPost.getTitle(),
                        itemPost.getHost_id(),
                        itemPost.getImage_path(),
                        itemPost.getPrice()
                )
        );

        return itemPostList;
    }

    public Page<ItemPostResponseDto> searchPageList(Pageable pageable, int pageNo, String keyword, String itemCategory, String orderCriteria) {

        /* 넘겨받은 orderCriteria 를 이용해 내림차순하여 Pageable 객체 반환 */
        if(orderCriteria.equals("highPrice")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "price"));
        } else if (orderCriteria.equals("lowPrice")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "price"));
        } else if (orderCriteria.equals("latest")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.DESC, "itemPostSeq"));
        } else if (orderCriteria.equals("deadline")) {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, "endTime"));
        } else {
            pageable = PageRequest.of(pageNo, 10, Sort.by(Sort.Direction.ASC, orderCriteria));
        };

        /* itemCategory에 해당하면서 keyword를 포함하는 post 페이지 객체 반환 */
        Page<ItemPost> page = itemPostRepository.findByItemCategoryAndTitleContaining(itemCategory, keyword, pageable);

        Page<ItemPostResponseDto> itemPostList = page.map(
                itemPost -> new ItemPostResponseDto(
                        itemPost.getItemPostSeq(),
                        itemPost.getTitle(),
                        itemPost.getHost_id(),
                        itemPost.getImage_path(),
                        itemPost.getPrice()

                )
        );

        return itemPostList;
    }

    //검색어 미포함 전체 리스트
    public Page<ItemPost> viewList(Pageable pageable) {

        return itemPostRepository.findAll(pageable);
    }



    //검색어 포함 리스트
    public Page<ItemPost> searchList(String searchKeyword, Pageable pageable) {

        return itemPostRepository.findByTitleContaining(searchKeyword, pageable);
    }


    //개별 조회
    @Transactional(readOnly = true)
    public ItemPostDto viewDetail(Long itemPostSeq) {
        ItemPost itemPost = itemPostRepository.findById(itemPostSeq).orElseThrow(()
                -> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));

        return new ItemPostDto(itemPost);
    }

    // 게시글 삭제

    @Transactional
    public void delete(Long itemPostSeq) {

        itemPostRepository.deleteById(itemPostSeq);
    }

    @Transactional
    public void update(Long itemPostSeq, ItemPostUpdateDto updateDto, MultipartFile file) throws Exception {
        ItemPost itemPost = itemPostRepository.findById(itemPostSeq).
                orElseThrow(()
                        -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID(); //식별자(랜덤이름 생성)

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        String image_name = fileName;
        String image_path = "/files/" + fileName;


        itemPost.update(updateDto.getTitle(), updateDto.getItem_name(), updateDto.getItemCategory(),
                updateDto.getPrice(), updateDto.getDelivery_fee(), updateDto.getDone_num(),
                updateDto.getEndTime(), updateDto.getLocation(), updateDto.getPoint(),
                updateDto.getContent(), image_name, image_path);
    }

    @Transactional
    public void updateState(Long itemPostSeq) {
        ItemPost itemPost = itemPostRepository.findById(itemPostSeq).
                orElseThrow(()
                        -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
        itemPost.updateState();
    }

}
    



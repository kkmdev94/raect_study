package hello.upload.controller;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 상품 저장을 위한 웹 폼(form)의 데이터를 전달받는 DTO(Data Transfer Object)입니다.
 *
 * 웹 클라이언트에서 파일을 업로드하면 Spring은 이를 `MultipartFile` 객체로 변환하여 전달합니다.
 * 이 `ItemForm`은 컨트롤러에서 해당 `MultipartFile` 데이터를 직접 받기 위해 사용됩니다.
 *
 * 실제 비즈니스 로직을 처리하는 도메인 모델(`Item`)과는 분리하여, 웹 계층의 역할을 명확히 합니다.
 */

@Data
public class ItemForm {

    private Long itemId;
    private String itemName;
    private MultipartFile attachFile;
    private List<MultipartFile> imageFiles;
}

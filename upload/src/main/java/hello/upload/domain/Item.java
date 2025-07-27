package hello.upload.domain;

import lombok.Data;

import java.util.List;

/**
 * 도메인 객체
 * 아이템
 */

@Data
public class Item {

    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}

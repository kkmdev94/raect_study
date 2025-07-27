package hello.upload.domain;

import lombok.Data;

/**
 * 업로드한 파일을 구분짓기 위한 객체
 */

@Data
public class UploadFile {

    private String uploadFileName; // 사용자가 업로드한 파일네임.
    private String storeFileName; // 시스템에 저장한 파일네임

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}

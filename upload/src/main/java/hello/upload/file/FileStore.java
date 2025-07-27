package hello.upload.file;

import hello.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 멀티파트 파일을 서버에 저장하는 역할을 담당한다.
 */

@Component
public class FileStore {

    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }

    public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UploadFile(originalFilename, storeFileName);
    }

    private String createStoreFileName(String originalFilename) {
        // 서버에 저장하는 파일명 / 그리고 확장자를 가져오고 싶음.
        String uuid = UUID.randomUUID().toString();
        // image.png
        String ext = extracted(originalFilename); // 메서드로 만들어서 반환하는 식으로 값을 받아서 . 뒤의 png를 뽑아온다.
        String storeFileName = uuid + "." + ext;
        // 이렇게 뽑으면 "qwe-qwe-123-qwe-qqwe.png" <- 이런식으로 뒤의 확장자를 뽑아서 서버 파일 저장명이랑 합칠 수 있다.

        return storeFileName;
    }

    private String extracted(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }

}

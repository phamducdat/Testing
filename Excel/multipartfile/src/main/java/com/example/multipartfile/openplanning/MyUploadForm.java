package com.example.multipartfile.openplanning;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class MyUploadForm {
    private String description;

    private MultipartFile[] fileDatas;
}

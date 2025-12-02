package kr.kro.moonlightmoist.shopapi.aws.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface S3UploadService {
    // 단일 파일 업로드 : path 예시 :  "products/1", 반환: url
    String uploadOneFile(MultipartFile file, String path);
//    List<String> uploadMultipleFiles()
}

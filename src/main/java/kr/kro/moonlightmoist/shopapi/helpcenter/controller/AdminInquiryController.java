package kr.kro.moonlightmoist.shopapi.helpcenter.controller;

import kr.kro.moonlightmoist.shopapi.helpcenter.dto.AdminInquiryListDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.InquiryListDTO;
import kr.kro.moonlightmoist.shopapi.helpcenter.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/admin/posts")
@RequiredArgsConstructor
public class AdminInquiryController {

    private final InquiryService inquiryService;

    // 문의 목록 조회
    @GetMapping("/inquiries")
    public ResponseEntity<AdminInquiryListDTO> getAllInquiries (
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String keyword
    ) {
        AdminInquiryListDTO result = inquiryService.getAdminInquiries(status, type, keyword);
        return ResponseEntity.ok(result);
    }

    // 답변 등록
//    @PostMapping()
//    public ResponseEntity<> createAnswer() {
//
//    }


    // 답변 수정

    // 문의 삭제




}

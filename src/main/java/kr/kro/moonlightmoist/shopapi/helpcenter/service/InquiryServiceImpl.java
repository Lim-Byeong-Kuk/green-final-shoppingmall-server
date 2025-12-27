package kr.kro.moonlightmoist.shopapi.helpcenter.service;

import jakarta.transaction.Transactional;
import kr.kro.moonlightmoist.shopapi.helpcenter.domain.Inquiry;
import kr.kro.moonlightmoist.shopapi.helpcenter.dto.*;
import kr.kro.moonlightmoist.shopapi.helpcenter.exception.InquiryNotFoundException;
import kr.kro.moonlightmoist.shopapi.helpcenter.repository.InquiryRepository;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.exception.UserNotFoundException;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryServiceImpl implements InquiryService{

    private final InquiryRepository inquiryRepository;
    private final UserRepository userRepository;

    @Override
    public InquiryCreateResponse registerInquiry(InquiryCreateRequest createRequest) {
        // 등록 서비스
        User user = userRepository.findByLoginId(createRequest.getLoginId())
                .orElseThrow(UserNotFoundException::new);
//        SELECT * FROM users WHERE login_id = 'user1';
//        조회된 모든 컬럼을 User 엔티티 객체로 매핑
//      1)  loginId는 단순히 검색 조건
//      2)  DB는 해당 조건에 맞는 row 전체를 반환
//      3)  JPA가 그 row의 모든 컬럼을 User 객체의 필드에 자동 매핑

        Inquiry createInquiry = Inquiry.builder()
                .user(user)
                .title(createRequest.getTitle())
                .content(createRequest.getContent())
                .inquiryType(createRequest.getInquiryType())
                .emailAgreement(createRequest.isEmailAgreement())
                .smsAgreement(createRequest.isSmsAgreement())
                .visible(true)
                .answered(false)
                .build();

        inquiryRepository.save(createInquiry);

        return InquiryCreateResponse.builder()
                .success(true)
                .message("문의가 정상적으로 등록 되었습니다.")
                .build();
    }

    @Override
    public InquiryListDTO getInquiryList(String loginId) {

            User user = userRepository.findByLoginId(loginId)
                    .orElseThrow(UserNotFoundException::new);
//        SELECT * FROM inquiry WHERE user_id = ?

            List<Inquiry> inquiries = inquiryRepository.findByUser(user);

            List<InquiryDTO> response = inquiries.stream()
                    .map(inquiry -> InquiryDTO.toInquiryDTO(inquiry)).collect(Collectors.toList());

            return new InquiryListDTO(response, response.size());

    }

    @Override
    public InquiryModifyResponse modifyInquiry(Long InquiryId, InquiryModifyRequest request, String loginId) {

        // loginId로 사용자를 찾고
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UserNotFoundException());

        // 해당 찾은 사용자의 문의를 찾음
        Inquiry inquiry = inquiryRepository.findById(InquiryId)
                .orElseThrow(() -> new InquiryNotFoundException());

        inquiry.updateInquiry(request);

        inquiryRepository.save(inquiry);

        return InquiryModifyResponse.builder()
                .id(inquiry.getId())
                .title(inquiry.getTitle())
                .inquiryContent(inquiry.getContent())
                .inquiryType(inquiry.getInquiryType().name())
                .inquiryTypeName(inquiry.getInquiryType().getTypeName()) // enum 내부 한글명 가져오기
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public void deleteInquiry(Long id, String loginId) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new InquiryNotFoundException("해당 문의가 존재하지 않습니다"));

        inquiryRepository.delete(inquiry);
    }

    @Override
    public AdminInquiryListDTO getAdminInquiries(String status, String type, String keyword) {
        List<Inquiry> allInquiries = inquiryRepository.findAll();

        List<Inquiry> filtered = allInquiries.stream()
                .filter(inquiry -> { // inquiry: 각 문의 객체 (하나씩 검사됨)

                    if ( status != null && !status.equals("ALL")) {
                        // status가 null이 아니고, "ALL"도 아닐 때만 필터링 실행
                        // → 즉, "PENDING" 또는 "ANSWERED"가 들어왔을 때
                        boolean isAnswered = status.equals("ANSWERED");
                        // status가 "ANSWERED"면 true, "PENDING"이면 false
                        // 실제 문의의 답변 상태와 비교
                        // 예: status="PENDING"이면 isAnswered=false
                        //     inquiry.isAnswered()=true인 문의는 제외됨 (return false)
                        if(inquiry.isAnswered() != isAnswered) {
                            return false; // 조건 안 맞으면 이 문의는 제외!
                        }
                    }
                    // status가 null이거나 "ALL"이면 이 필터는 통과 (모두 허용)

                    if(type != null && !type.equals("전체")){
                        // type이 null이 아니고, "전체"도 아닐 때만 필터링 실행
                        if(!inquiry.getInquiryType().getTypeName().equals(type)) {
                            // 문의의 실제 유형(한글명)과 비교
                            // inquiry.getInquiryType() → InquiryType.DELIVERY (enum)
                            // .getTypeName() → "배송문의" (enum의 한글명)
                            return false; // 유형이 다르면 제외
                        }
                    }

                    if(keyword != null && !keyword.trim().isEmpty()) {
                        // keyword가 null이 아니고, 공백도 아닐 때만 검색 실행
                        return inquiry.getTitle().contains(keyword) ||
                                inquiry.getContent().contains(keyword);
                        // 제목 또는 내용에 키워드가 포함되어 있는지 확인
                        // .contains(): 문자열에 특정 문자가 포함되어 있으면 true

                        // 예: keyword="배송"
                        //     title="배송 문의합니다" → true (포함)
                        //     title="반품 요청" → false (불포함)
                    }
                    return true;  // 모든 필터를 통과하면 true 반환 (이 문의는 결과에 포함)
                }).collect(Collectors.toList());  // Stream을 다시 List로 변환 필터링 완료! 예: [문의1, 문의5, 문의7] 3건만 남음

        List<AdminInquiryDTO> dtoList = filtered.stream()
                .map(inquiry -> AdminInquiryDTO.toEntity(inquiry))
                .collect(Collectors.toList());

        return new AdminInquiryListDTO(dtoList, dtoList.size());
    }


}

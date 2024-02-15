package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//@Tag(name = "title", description = "content")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/clubs/informations")
public class TeamArticleController {
    // swegar 설정
//    @Operation(summary = "신입 가입 신청", description = "신입 가입 신청을 하지만 회원 가입이 아님을 인지하자. TempUser에 저장")
    @PutMapping("/{club_id}/articles/{article_id}")
    public ResponseEntity<SignNewUserResDto> userSignFrom(@RequestBody @Valid TempUserFormReqDto requestUserForm) {
        String email = requestUserForm.getEmail();

        tempUserService.save(requestUserForm);
        Boolean existNewUser = tempUserService.exist(email);

        // 등록 완료 되었다는 boolean 리턴
        return ResponseEntity.ok().body(SignNewUserResDto.builder()
                .isApply(existNewUser)
                .build());
    }
}

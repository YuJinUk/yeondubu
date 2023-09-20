package yeon.dubu.category.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yeon.dubu.category.domain.TagExpenditure;
import yeon.dubu.category.service.TagExpenditureService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tags")
public class TagExpenditureController {

    private final TagExpenditureService tagExpenditureService;

    /**
     * firstTagName 등록
     * @param userId
     * @param firstTagName
     * @return
     */
    @PostMapping("/{firstTagName}")
    public ResponseEntity saveFirstTag(
            @AuthenticationPrincipal Long userId,
            @PathVariable String firstTagName
    ) {
        TagExpenditure savedFirstTag = tagExpenditureService.saveFirstTag(firstTagName, userId);

        return ResponseEntity.ok(savedFirstTag);
    }

    /**
     * secondTagName 등록
     * @param userId
     * @param firstTagName
     * @param secondTagName
     * @return
     */
    @PostMapping("/{firstTagName}/{secondTagName}")
    public ResponseEntity saveSecondTag(
            @AuthenticationPrincipal Long userId,
            @PathVariable String firstTagName,
            @PathVariable String secondTagName
    ) {
        TagExpenditure savedSecondTag = tagExpenditureService.saveSecondTag(firstTagName, secondTagName, userId);

        return ResponseEntity.ok(savedSecondTag);
    }

    /**
     * thirdTag 등록
     * @param userId
     * @param firstTagName
     * @param secondTagName
     * @param thirdTagName
     * @return
     */
    @PostMapping("/{firstTagName}/{secondTagName}/{thirdTagName}")
    public ResponseEntity saveSecondTag(
            @AuthenticationPrincipal Long userId,
            @PathVariable String firstTagName,
            @PathVariable String secondTagName,
            @PathVariable String thirdTagName
    ) {
        TagExpenditure savedThirdTag = tagExpenditureService.saveThirdTag(firstTagName, secondTagName, thirdTagName, userId);

        return ResponseEntity.ok(savedThirdTag);
    }

}

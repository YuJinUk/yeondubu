package yeon.dubu.money.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import yeon.dubu.money.dto.response.TotalExpectExpenditureResDto;
import yeon.dubu.money.domain.Money;
import yeon.dubu.money.dto.request.MoneyCashReqDto;
import yeon.dubu.money.dto.response.MoneyCashResDto;
import yeon.dubu.money.service.MoneyService;

import java.net.URISyntaxException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/money")
public class MoneyController {

    private MoneyService moneyService;

    /**
     * 사용자의 현금 등록
     * @param userId
     * @param moneyCashReqDto
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/cash")
    public ResponseEntity<?> insertCash(
            @AuthenticationPrincipal Long userId,
            @RequestBody MoneyCashReqDto moneyCashReqDto
    ) throws URISyntaxException {
        Money cash = moneyService.insertCash(moneyCashReqDto, userId);

        return ResponseEntity.ok(cash);
    }

    @GetMapping("/total-expect")
    public ResponseEntity<?> searchTotalExpectExpenditure(
            @AuthenticationPrincipal Long userId
    ) {
        TotalExpectExpenditureResDto totalExpectExpenditure = moneyService.searchTotalExpectExpenditure(userId);

        return ResponseEntity.ok(totalExpectExpenditure);
    }

    @GetMapping("/total-cash")
    public ResponseEntity<?> searchTotalCash(
            @AuthenticationPrincipal Long userId
    ) {
        MoneyCashResDto totalCash = moneyService.searchTotalCash(userId);

        return ResponseEntity.ok(totalCash);
    }
}

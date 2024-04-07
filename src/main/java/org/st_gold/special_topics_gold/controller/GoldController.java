package org.st_gold.special_topics_gold.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.st_gold.special_topics_gold.dto.BuyGoldDTO;
import org.st_gold.special_topics_gold.dto.GoldDTO;
import org.st_gold.special_topics_gold.dto.SellGoldDTO;
import org.st_gold.special_topics_gold.model.Gold;
import org.st_gold.special_topics_gold.service.GoldService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/gold")
@RestController
public class GoldController {
    private final GoldService goldService;
    public GoldController(GoldService goldService) {
        this.goldService = goldService;
    }

    @GetMapping("/price-history")
    public ResponseEntity<List<GoldDTO>> getGoldPriceHistory(){
        List<Gold> goldPriceHistory = goldService.getGoldPriceHistory();
        List< GoldDTO> goldDTOs = goldPriceHistory.stream().map(GoldDTO::fromEntity).collect(Collectors.toList());
        return new ResponseEntity<>(goldDTOs, HttpStatus.OK);
    }
    @PostMapping("/calculate-value")
    public ResponseEntity<GoldDTO>  calculateGoldValue(){
        Gold gold = goldService.calculateGoldValue();
        GoldDTO goldDTO = GoldDTO.fromEntity(gold);
        return new ResponseEntity<>(goldDTO, HttpStatus.OK);
    }

    @PostMapping("/sell")
    public boolean sellGold(@RequestBody SellGoldDTO sellGoldDTO){
        goldService.sellGold(sellGoldDTO);
        return true;
    }
    @PostMapping("/buy")
    public boolean buyGold(@RequestBody BuyGoldDTO buyGoldDTO){
        goldService.buyGold(buyGoldDTO);
        return true;
    }
}

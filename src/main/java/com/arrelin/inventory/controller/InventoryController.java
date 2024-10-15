package com.arrelin.inventory.controller;

import com.arrelin.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isIntStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        log.trace("Checking if there is enough stock for skuCode: '{}' and quantity: '{}'", skuCode, quantity);
        return inventoryService.isIntStock(skuCode, quantity);
    }

}

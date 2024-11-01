package com.example.InventoryService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @GetMapping("/{productId}")
    public String getInventoryDetails(@PathVariable String productId) {
        // Lógica para obtener detalles del inventario
        return "Detalles de inventario para el producto: " + productId;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}

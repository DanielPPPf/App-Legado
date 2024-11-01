package com.example;

import com.example.InventoryController.InventoryControllerLegacy;

public class MainApplication {

    public static void main(String[] args) {
        InventoryControllerLegacy controller = new InventoryControllerLegacy();

        // Muestra los detalles de un producto
        controller.showInventory("ABC123");
    }
}

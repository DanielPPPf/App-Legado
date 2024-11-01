package com.example.InventoryController;

import com.example.InventoryService.InventoryServiceFacade;
import com.example.InventoryService.InventoryServiceLegacy;

public class InventoryControllerLegacy {

	private InventoryServiceFacade inventoryFacade = new InventoryServiceFacade();

	public void showInventory(String productId) {
		// Obtiene los detalles de inventario, redirigiendo al microservicio si está disponible
		String inventoryDetails = inventoryFacade.getInventoryDetails(productId);

		// Muestra el resultado
		System.out.println(inventoryDetails);
	}
}

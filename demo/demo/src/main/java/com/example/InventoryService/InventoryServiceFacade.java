package com.example.InventoryService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class InventoryServiceFacade {

    private InventoryServiceLegacy legacyService = new InventoryServiceLegacy();

    public String getInventoryDetails(String productId) {
        // Verificar si el nuevo microservicio está disponible
        if (isNewServiceAvailable()) {
            return callNewInventoryService(productId);
        }
        // Si no está disponible, usa el servicio antiguo
        return legacyService.getInventoryDetails(productId);
    }

    private boolean isNewServiceAvailable() {
        // Implementación simple para verificar disponibilidad (por ejemplo, ping al microservicio)
        try {
            URL url = new URL("http://localhost:8080/api/inventory/health");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            return conn.getResponseCode() == 200;
        } catch (Exception e) {
            return false;
        }
    }

    private String callNewInventoryService(String productId) {
        try {
            URL url = new URL("http://localhost:8080/api/inventory/" + productId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error al consultar el nuevo servicio de inventario";
        }
    }
}

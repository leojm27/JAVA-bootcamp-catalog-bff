package com.morales.catalog_bff.clients;

import com.morales.catalog_bff.models.InventarioProducto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// @FeignClient(name = "ms-inventory", url = "${inventory.service.url}")
@FeignClient(name = "ms-inventory", url = "http://localhost:8081/api")
public interface InventoryClient {

    @GetMapping("/inventario-producto")
    List<InventarioProducto> getInventarioProductos();

    @GetMapping("inventario-producto/{id}")
    InventarioProducto getInventarioProducto(@PathVariable Long id);

}

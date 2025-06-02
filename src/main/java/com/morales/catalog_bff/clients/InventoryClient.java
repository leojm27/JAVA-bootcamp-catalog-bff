package com.morales.catalog_bff.clients;

import com.morales.catalog_bff.dto.InventarioProductoDTO;
import com.morales.catalog_bff.security.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// @FeignClient(name = "ms-inventory", url = "${inventory.service.url}")
@FeignClient(
        name = "ms-inventory",
        url = "${ms-inventory-url}",
        configuration = FeignClientConfig.class)
public interface InventoryClient {

    /**
     * Obtiene la lista de inventarios de productos.
     * @return Lista de InventarioProductoDTO
     */
    @GetMapping("/inventario-producto")
    List<InventarioProductoDTO> getInventarioProductos();

    /**
     * Obtiene un inventario de producto por su ID.
     * @param id ID del inventario de producto
     * @return InventarioProductoDTO
     */
    @GetMapping("inventario-producto/por-producto/{productId}")
    InventarioProductoDTO getInventarioProductoPorProductoId(@PathVariable Long productId);

    /**
     * Crea un nuevo inventario de producto.
     * @param inventarioProductoDTO DTO del inventario de producto a crear
     * @return InventarioProductoDTO creado
     */
    @PostMapping("/inventario-producto")
    InventarioProductoDTO createInventarioProducto(InventarioProductoDTO inventarioProductoDTO);

}

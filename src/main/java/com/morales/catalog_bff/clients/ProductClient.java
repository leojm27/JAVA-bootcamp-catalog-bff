package com.morales.catalog_bff.clients;

import com.morales.catalog_bff.dto.CategoriaDTO;
import com.morales.catalog_bff.dto.ProductoDTO;
import com.morales.catalog_bff.security.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "ms-product",
        url = "${ms-product-url}",
        configuration = FeignClientConfig.class)
public interface ProductClient {

    /**
     * Retorna una lista de productos.
     */
    @GetMapping("/productos")
    List<ProductoDTO> getProductos();

    /**
     * Retorna un producto por su ID.
     * @param id ID del producto a buscar.
     */
    @GetMapping("/productos/{id}")
    ProductoDTO getProductoById(@PathVariable Long id);

    /**
     * Retorna una lista de categorías.
     */
    @GetMapping("/categorias")
    List<CategoriaDTO> getCategorias();

    /**
     * Retorna una categoría por su ID.
     * @param id ID de la categoría a buscar.
     */
    @GetMapping("/categorias/{id}")
    CategoriaDTO getCategoriaById(@PathVariable Long id);

}

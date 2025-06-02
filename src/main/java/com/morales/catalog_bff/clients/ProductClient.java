package com.morales.catalog_bff.clients;

import com.morales.catalog_bff.models.Categoria;
import com.morales.catalog_bff.models.Producto;
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

    @GetMapping("/productos")
    List<Producto> getProductos();

    @GetMapping("/productos/{id}")
    Producto getProductoById(@PathVariable Long id);

    @GetMapping("/categorias")
    List<Categoria> getCategorias();

    @GetMapping("/categorias/{id}")
    Categoria getCategoriaById(@PathVariable Long id);

}

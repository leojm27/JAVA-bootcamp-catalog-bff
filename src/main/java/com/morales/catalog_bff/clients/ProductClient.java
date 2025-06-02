package com.morales.catalog_bff.clients;

import com.morales.catalog_bff.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-inventory", url = "http://localhost:8082/api")
public interface ProductClient {

    @GetMapping("/productos")
    List<Producto> getProductos();

    @GetMapping("/productos/{id}")
    Producto getProductoById(@PathVariable Long id);

}

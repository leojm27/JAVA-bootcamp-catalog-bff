package com.morales.catalog_bff.clients;

import com.morales.catalog_bff.models.Categoria;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-inventory", url = "http://localhost:8082/api")
public interface CategoriaClient {

    @GetMapping("/categorias")
    List<Categoria> getCategorias();

    @GetMapping("/categorias/{id}")
    Categoria createCategoria(@PathVariable Long id);
}

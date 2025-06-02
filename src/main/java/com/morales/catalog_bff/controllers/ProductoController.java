package com.morales.catalog_bff.controllers;

import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductoController {

    private final CatalogoService catalogoService;

    @GetMapping("/api/catalogo/productos")
    public ResponseEntity<?> getCatalogoProductos(){
        try {
            return ResponseEntity.ok(catalogoService.getCatalogoProductos());
        } catch (Exception e) {
            return ResponseEntity
                    .status(500)
                    .body("Error al obtener catálogo de productos");
        }
    }

    @GetMapping("/api/catalogo/productos/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id) {
        try {
            CatalogoProductoDTO catalogoProductoDTO = catalogoService.getProductoById(id);
            if (catalogoProductoDTO != null) {
                return ResponseEntity.ok(catalogoProductoDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al obtener producto con ID " + id);
        }
    }
}

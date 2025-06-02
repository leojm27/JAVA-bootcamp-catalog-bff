package com.morales.catalog_bff.controllers;

import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CatalogoController {

    private final CatalogoService catalogoService;

    /**
     * Obtiene todos los productos del catálogo.
     * @return ResponseEntity con la lista de productos o un mensaje de error.
     */
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

    /**
     * Obtiene un producto del catálogo por su ID.
     * @param id ID del producto a buscar.
     * @return ResponseEntity con el producto encontrado o un mensaje de error.
     */
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

    @PostMapping("/api/catalogo/productos")
    public ResponseEntity<?> createProducto(@RequestBody CatalogoProductoDTO catalogoProductoDTO) {
        try {
            CatalogoProductoDTO nuevoCatalogoProducto = catalogoService.createProducto(catalogoProductoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCatalogoProducto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear producto: " + e.getMessage());
        }
    }
}

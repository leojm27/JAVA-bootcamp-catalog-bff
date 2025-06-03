package com.morales.catalog_bff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoProductoDTO {

    private Long productoId;

    private String productoNombre;

    private String productoDescripcion;

    private Double productoPrecio;

    private Long categoriaId;

    private String categoriaNombre;

    private  String categoriaDescripcion;

    private Long inventarioId;

    private Long inventarioCantidad;

    private Long inventarioCantidadMinima;

    public CatalogoProductoDTO(String productoNombre, String productoDescripcion, Double productoPrecio, Long categoriaId, Long inventarioCantidad, Long inventarioCantidadMinima) {
        this.productoNombre = productoNombre;
        this.productoDescripcion = productoDescripcion;
        this.productoPrecio = productoPrecio;
        this.categoriaId = categoriaId;
        this.inventarioCantidad = inventarioCantidad;
        this.inventarioCantidadMinima = inventarioCantidadMinima;
    }
}

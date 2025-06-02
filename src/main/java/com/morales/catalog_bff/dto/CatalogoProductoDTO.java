package com.morales.catalog_bff.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CatalogoProductoDTO {
    private Long productoId;
    private String productoName;
    private String productoDescripcion;
    private Double productoPrecio;
    private Long categoriaId;
    private String categoriaNombre;
    private  String categoriaDescripcion;

    public CatalogoProductoDTO(Long productoId, String productoName, String productoDescripcion, Double productoPrecio, Long categoriaId, String categoriaNombre, String categoriaDescripcion) {
        this.productoId = productoId;
        this.productoName = productoName;
        this.productoDescripcion = productoDescripcion;
        this.productoPrecio = productoPrecio;
        this.categoriaId = categoriaId;
        this.categoriaNombre = categoriaNombre;
        this.categoriaDescripcion = categoriaDescripcion;
    }
}

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

}

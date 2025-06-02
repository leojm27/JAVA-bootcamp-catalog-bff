package com.morales.catalog_bff.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioProducto {
    private Long id;
    private Long productoId;
    private Long cantidad;
    private Long cantidadMinima;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    /*public InventarioProducto(Long productoId, Long cantidad, Long cantidadMinima) {
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.cantidadMinima = cantidadMinima;
    }*/
}

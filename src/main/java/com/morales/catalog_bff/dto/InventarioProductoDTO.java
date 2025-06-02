package com.morales.catalog_bff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioProductoDTO {

    private Long id;

    private Long productoId;

    private Long cantidad;

    private Long cantidadMinima;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}

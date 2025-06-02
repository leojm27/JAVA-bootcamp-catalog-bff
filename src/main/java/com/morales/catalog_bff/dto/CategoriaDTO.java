package com.morales.catalog_bff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

}

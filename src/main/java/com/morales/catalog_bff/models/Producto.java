package com.morales.catalog_bff.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Long idCategoria;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    /*public Producto(String nombre, String descripcion, Double precio, Long idCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idCategoria = idCategoria;
    }*/
}

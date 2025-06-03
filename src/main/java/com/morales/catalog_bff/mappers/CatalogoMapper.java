package com.morales.catalog_bff.mappers;

import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.dto.CategoriaDTO;
import com.morales.catalog_bff.dto.InventarioProductoDTO;
import com.morales.catalog_bff.dto.ProductoDTO;

import java.util.List;
import java.util.Objects;

public class CatalogoMapper {

    /** * Mapea una lista de ProductoDTO, CategoriaDTO e InventarioProductoDTO a una lista de CatalogoProductoDTO.
     *
     * @param productos Lista de ProductoDTO.
     * @param categorias Lista de CategoriaDTO.
     * @param inventarios Lista de InventarioProductoDTO.
     * @return Retorna una lista de CatalogoProductoDTO con los datos combinados de los tres DTOs.
     */
    public static List<CatalogoProductoDTO> mapToCatalogProductDTOList(List<ProductoDTO> productos, List<CategoriaDTO> categorias, List<InventarioProductoDTO> inventarios) {
        return productos.stream()
                .map(producto -> {
                    CategoriaDTO categoria = categorias.stream()
                            .filter(cat -> cat.getId().equals(producto.getIdCategoria()))
                            .findFirst()
                            .orElse(null);

                    InventarioProductoDTO inventarioProducto = inventarios.stream()
                            .filter(inv -> inv.getProductoId().equals(producto.getId()))
                            .findFirst()
                            .orElse(null);

                    if (categoria == null || inventarioProducto == null) {
                        return null;
                    }

                    return mapToCatalogProductDTO(producto, categoria, inventarioProducto);
                })
                .filter(Objects::nonNull)
                .toList();
    }

    /** * Mapea un ProductoDTO, CategoriaDTO e InventarioProductoDTO a un CatalogoProductoDTO.
     *
     * @param producto          ProductoDTO.
     * @param categoria         CategoriaDTO.
     * @param inventarioProducto InventarioProductoDTO.
     * @return Retorna CatalogoProductoDTO con los datos combinados de los tres DTOs.
     */
    public static CatalogoProductoDTO mapToCatalogProductDTO(ProductoDTO producto, CategoriaDTO categoria, InventarioProductoDTO inventarioProducto) {
        CatalogoProductoDTO catalogoProductoDTO = new CatalogoProductoDTO();
        catalogoProductoDTO.setProductoId(producto.getId());
        catalogoProductoDTO.setProductoNombre(producto.getNombre());
        catalogoProductoDTO.setProductoDescripcion(producto.getDescripcion());
        catalogoProductoDTO.setProductoPrecio(producto.getPrecio());
        catalogoProductoDTO.setCategoriaId(categoria.getId());
        catalogoProductoDTO.setCategoriaNombre(categoria.getNombre());
        catalogoProductoDTO.setCategoriaDescripcion(categoria.getDescripcion());
        catalogoProductoDTO.setInventarioId(inventarioProducto.getId());
        catalogoProductoDTO.setInventarioCantidad(inventarioProducto.getCantidad());
        catalogoProductoDTO.setInventarioCantidadMinima(inventarioProducto.getCantidadMinima());
        return catalogoProductoDTO;
    }

}

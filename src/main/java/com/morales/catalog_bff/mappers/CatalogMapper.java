package com.morales.catalog_bff.mappers;

import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.models.Categoria;
import com.morales.catalog_bff.models.InventarioProducto;
import com.morales.catalog_bff.models.Producto;

import java.util.List;

public class CatalogMapper {

    public static List<CatalogoProductoDTO> mapToCatalogProductDTOList(List<Producto> productos, List<Categoria> categorias, List<InventarioProducto> inventarios) {
        return productos.stream()
                .map(producto -> {
                    Categoria categoria = categorias.stream()
                            .filter(cat -> cat.getId().equals(producto.getIdCategoria()))
                            .findFirst()
                            .orElse(null);

                    InventarioProducto inventarioProducto = inventarios.stream()
                            .filter(inv -> inv.getProductoId().equals(producto.getId()))
                            .findFirst()
                            .orElse(null);

                    if (categoria == null || inventarioProducto == null) {
                        return null;
                    }

                    return mapToCatalogProductDTO(producto, categoria, inventarioProducto);
                })
                .toList();
    }

    public static CatalogoProductoDTO mapToCatalogProductDTO(Producto producto, Categoria categoria, InventarioProducto inventarioProducto) {
        CatalogoProductoDTO catalogoProductoDTO = new CatalogoProductoDTO();
        catalogoProductoDTO.setProductoId(producto.getId());
        catalogoProductoDTO.setProductoName(producto.getNombre());
        catalogoProductoDTO.setProductoDescripcion(producto.getDescripcion());
        catalogoProductoDTO.setProductoPrecio(producto.getPrecio());
        catalogoProductoDTO.setCategoriaId(categoria.getId());
        catalogoProductoDTO.setCategoriaNombre(categoria.getNombre());
        catalogoProductoDTO.setCategoriaDescripcion(categoria.getDescripcion());
        catalogoProductoDTO.setInventarioId(inventarioProducto.getId());
        catalogoProductoDTO.setInventarioCantidad(inventarioProducto.getCantidad());
        return catalogoProductoDTO;
    }

}

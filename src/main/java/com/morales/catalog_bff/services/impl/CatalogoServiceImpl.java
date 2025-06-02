package com.morales.catalog_bff.services.impl;

import com.morales.catalog_bff.clients.InventoryClient;
import com.morales.catalog_bff.clients.ProductClient;
import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.dto.CategoriaDTO;
import com.morales.catalog_bff.dto.InventarioProductoDTO;
import com.morales.catalog_bff.dto.ProductoDTO;
import com.morales.catalog_bff.services.CatalogoService;
import com.morales.catalog_bff.mappers.CatalogoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {

    private final ProductClient productClient;
    private final InventoryClient inventoryClient;

    @Override
    public List<CatalogoProductoDTO> getCatalogoProductos() {
        List<ProductoDTO> productos = productClient.getProductos();
        List<CategoriaDTO> categorias = productClient.getCategorias();
        List<InventarioProductoDTO> inventarios = inventoryClient.getInventarioProductos();

        return CatalogoMapper.mapToCatalogProductDTOList(productos, categorias, inventarios);
    }



    @Override
    public CatalogoProductoDTO getProductoById(Long id) {
        CategoriaDTO categoria = null;
        InventarioProductoDTO inventarioProducto = null;
        ProductoDTO producto = productClient.getProductoById(id);

        if(producto != null){
            categoria = productClient.getCategoriaById(producto.getIdCategoria());
            inventarioProducto = inventoryClient.getInventarioProductoPorProductoId(producto.getId());
        }

        if (producto != null && categoria != null && inventarioProducto != null) {
            return CatalogoMapper.mapToCatalogProductDTO(producto, categoria, inventarioProducto);
        }

        return null;
    }

}

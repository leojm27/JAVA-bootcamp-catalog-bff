package com.morales.catalog_bff.services.impl;

import com.morales.catalog_bff.clients.InventoryClient;
import com.morales.catalog_bff.clients.ProductClient;
import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.models.Categoria;
import com.morales.catalog_bff.models.InventarioProducto;
import com.morales.catalog_bff.models.Producto;
import com.morales.catalog_bff.services.CatalogoService;
import com.morales.catalog_bff.mappers.CatalogMapper;
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
        List<Producto> productos = productClient.getProductos();
        List<Categoria> categorias = productClient.getCategorias();
        List<InventarioProducto> inventarios = inventoryClient.getInventarioProductos();

        return CatalogMapper.mapToCatalogProductDTOList(productos, categorias, inventarios);
    }



    @Override
    public CatalogoProductoDTO getProductoById(Long id) {
        Categoria categoria = null;
        InventarioProducto inventarioProducto = null;
        Producto producto = productClient.getProductoById(id);

        if(producto != null){
            categoria = productClient.getCategoriaById(producto.getIdCategoria());
            inventarioProducto = inventoryClient.getInventarioProductoPorProductoId(producto.getId());
        }

        if (producto != null && categoria != null && inventarioProducto != null) {
            return CatalogMapper.mapToCatalogProductDTO(producto, categoria, inventarioProducto);
        }

        return null;
    }

}

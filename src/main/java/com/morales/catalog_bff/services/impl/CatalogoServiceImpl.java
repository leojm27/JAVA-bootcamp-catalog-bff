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

    @Override
    public CatalogoProductoDTO createProducto(CatalogoProductoDTO productoCrear) {
        ProductoDTO productoCreado;
        InventarioProductoDTO inventarioCreado;
        CategoriaDTO categoria = productClient.getCategoriaById(productoCrear.getCategoriaId());

        if (categoria == null) {
            throw new IllegalArgumentException("Categoría no encontrada, Id: " + productoCrear.getCategoriaId());
        }

        ProductoDTO producto = new ProductoDTO(
                productoCrear.getProductoNombre(),
                productoCrear.getProductoDescripcion(),
                productoCrear.getProductoPrecio(),
                productoCrear.getCategoriaId()
        );

        try {
            productoCreado = productClient.createProducto(producto);
            InventarioProductoDTO inventarioProducto = new InventarioProductoDTO(
                    productoCreado.getId(),
                    productoCrear.getInventarioCantidad(),
                    productoCrear.getInventarioCantidadMinima()
            );

            try {
                inventarioCreado = inventoryClient.createInventarioProducto(inventarioProducto);
                if (inventarioCreado == null) {
                    throw new RuntimeException("Error al crear el inventario del producto");
                }
            } catch (Exception e) {
                productClient.softDeleteProducto(productoCreado.getId());
                throw new RuntimeException("Error al crear el inventario del producto: " + e.getMessage(), e);
            }

            return CatalogoMapper.mapToCatalogProductDTO(productoCreado, categoria, inventarioCreado);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el producto: " + e.getMessage(), e);
        }
    }

}

package com.morales.catalog_bff.services.impl;

import com.morales.catalog_bff.clients.CategoriaClient;
import com.morales.catalog_bff.clients.InventoryClient;
import com.morales.catalog_bff.clients.ProductClient;
import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.services.CatalogoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogoServiceImpl implements CatalogoService {

    private final ProductClient productClient;
    private final InventoryClient inventoryClient;
    private final CategoriaClient categoriaClient;

    @Override
    public List<CatalogoProductoDTO> getCatalogoProductos() {
        return List.of();
    }

    @Override
    public CatalogoProductoDTO getProductoById(Long id) {
        return new CatalogoProductoDTO();
    }
}

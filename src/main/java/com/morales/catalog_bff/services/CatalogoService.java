package com.morales.catalog_bff.services;


import com.morales.catalog_bff.dto.CatalogoProductoDTO;

import java.util.List;

public interface CatalogoService {

    List<CatalogoProductoDTO> getCatalogoProductos();

    CatalogoProductoDTO getProductoById(Long id);

    CatalogoProductoDTO createProducto(CatalogoProductoDTO producto);
}

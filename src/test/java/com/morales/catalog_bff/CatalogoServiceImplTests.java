package com.morales.catalog_bff;

import com.morales.catalog_bff.clients.InventoryClient;
import com.morales.catalog_bff.clients.ProductClient;
import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.dto.CategoriaDTO;
import com.morales.catalog_bff.dto.InventarioProductoDTO;
import com.morales.catalog_bff.dto.ProductoDTO;
import com.morales.catalog_bff.services.impl.CatalogoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class CatalogoServiceImplTests {

    private MockMvc mockMvc;

    @Mock
    private ProductClient productClient;

    @Mock
    private InventoryClient inventoryClient;

    @InjectMocks
    private CatalogoServiceImpl catalogoServiceImpl;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(catalogoServiceImpl).build();
    }

    ProductoDTO productoDTOMock = new ProductoDTO(
            1L,
            "Teclado mecánico Redragon Kumara",
            "Teclado gamer con retroiluminación LED RGB",
            100.0, 1L
    );

    CategoriaDTO categoriaDTOMock = new CategoriaDTO(
            1L,
            "Computación",
            "Productos relacionados con computadoras, accesorios y tecnología."
    );

    InventarioProductoDTO inventarioProductoDTOMock = new InventarioProductoDTO(
            1L,
            1L,
            28L,
            5L
    );

    /* getCatalogoProductos */
    @Test
    void testGetCatalogoProductos(){
        List<ProductoDTO> productos = List.of(productoDTOMock);
        List<CategoriaDTO> categorias = List.of(categoriaDTOMock);
        List<InventarioProductoDTO> inventarios = List.of(inventarioProductoDTOMock);

        when(productClient.getProductos()).thenReturn(productos);
        when(productClient.getCategorias()).thenReturn(categorias);
        when(inventoryClient.getInventarioProductos()).thenReturn(inventarios);

        List<CatalogoProductoDTO> result = catalogoServiceImpl.getCatalogoProductos();
        assertThat(result).isNotNull();
    }

    /* getProductoById */
    @Test
    void testgetProductoById(){
        Long id = 1L;
        when(productClient.getProductoById(id)).thenReturn(productoDTOMock);
        when(productClient.getCategoriaById(productoDTOMock.getIdCategoria())).thenReturn(categoriaDTOMock);
        when(inventoryClient.getInventarioProductoPorProductoId(id)).thenReturn(inventarioProductoDTOMock);

        CatalogoProductoDTO result = catalogoServiceImpl.getProductoById(id);
        assertThat(result).isNotNull();
        assertThat(result.getProductoId()).isEqualTo(id);
    }

    @Test
    void shouldReturnNullEnTodosLosMetodosGetProductoById(){
        Long id = 1L;
        when(productClient.getProductoById(id)).thenReturn(null);
        when(productClient.getCategoriaById(productoDTOMock.getIdCategoria())).thenReturn(null);
        when(inventoryClient.getInventarioProductoPorProductoId(id)).thenReturn(null);

        CatalogoProductoDTO result = catalogoServiceImpl.getProductoById(id);
        assertThat(result).isNull();
    }


}

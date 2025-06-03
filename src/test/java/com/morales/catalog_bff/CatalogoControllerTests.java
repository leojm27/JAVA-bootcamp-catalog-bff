package com.morales.catalog_bff;

import com.morales.catalog_bff.controllers.CatalogoController;
import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.dto.ProductoDTO;
import com.morales.catalog_bff.services.CatalogoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CatalogoControllerTests {

    private MockMvc mockMvc;

    @Mock
    private CatalogoService catalogoService;

    @InjectMocks
    private CatalogoController catalogoController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(catalogoController)
                .build();
    }

    /* getCatalogoProductos */
    @Test
    void testGetCatalogoProductos(){
        when(catalogoService.getCatalogoProductos())
                .thenReturn(List.of());

        ResponseEntity<?> response = catalogoController.getCatalogoProductos();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnExceptionInGetCatalogoProductos() {
        when(catalogoService.getCatalogoProductos())
                .thenThrow(new RuntimeException("Error al obtener catálogo de productos"));

        ResponseEntity<?> response = catalogoController.getCatalogoProductos();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isEqualTo("Error al obtener catálogo de productos");
    }

    /* getProductoById */

    @Test
    void testGetProductoById() {
        Long id = 1L;
        when(catalogoService.getProductoById(id))
                .thenReturn(
                        new CatalogoProductoDTO(
                                1L,
                                "Teclado mecánico Redragon Kumara",
                                "Teclado gamer con retroiluminación LED RGB",
                                18999.0,
                                1L,
                                "Computación",
                                "Productos relacionados con computadoras, accesorios y tecnología.",
                                1L,
                                28L,
                                10L
                ));

        ResponseEntity<?> response = catalogoController.getProductoById(id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnNullGetProductoById(){
        Long id = 1L;
        when(catalogoService.getProductoById(id))
                .thenReturn(null);

        ResponseEntity<?> response = catalogoController.getProductoById(id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldReturnExceptionInGetProductoById() {
        Long id = 1L;
        when(catalogoService.getProductoById(id))
                .thenThrow(new RuntimeException("Error al obtener producto con ID " + id));

        ResponseEntity<?> response = catalogoController.getProductoById(id);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).isEqualTo("Error al obtener producto con ID " + id);
    }

    /* createProducto */
    @Test
    void testCreateProducto() {
        CatalogoProductoDTO catalogoProductoDTO = new CatalogoProductoDTO(
                1L,
                "Teclado mecánico Redragon Kumara",
                "Teclado gamer con retroiluminación LED RGB",
                18999.0,
                1L,
                "Computación",
                "Productos relacionados con computadoras, accesorios y tecnología.",
                1L,
                28L,
                10L
        );

        when(catalogoService.createProducto(catalogoProductoDTO))
                .thenReturn(catalogoProductoDTO);

        ResponseEntity<?> response = catalogoController.createProducto(catalogoProductoDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isEqualTo(catalogoProductoDTO);
    }

    @Test
    void shouldReturnExceptionInCreateProducto() {
        CatalogoProductoDTO catalogoProductoDTO = new CatalogoProductoDTO(
                1L,
                "Teclado mecánico Redragon Kumara",
                "Teclado gamer con retroiluminación LED RGB",
                18999.0,
                1L,
                "Computación",
                "Productos relacionados con computadoras, accesorios y tecnología.",
                1L,
                28L,
                10L
        );

        when(catalogoService.createProducto(catalogoProductoDTO))
                .thenThrow(new RuntimeException("Error al crear producto"));

        ResponseEntity<?> response = catalogoController.createProducto(catalogoProductoDTO);
        System.out.println("Response: " + response);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

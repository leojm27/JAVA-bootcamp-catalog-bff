package com.morales.catalog_bff.init;

import com.morales.catalog_bff.dto.CatalogoProductoDTO;
import com.morales.catalog_bff.services.CatalogoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
public class LoadData {

    @Transactional
    @Bean
    CommandLineRunner initData(CatalogoService catalogoService){
        return args -> {
            System.out.println("Cargando datos iniciales...");
            List<CatalogoProductoDTO> catalogoInicial = List.of(
                    // Computación (ID: 1L)
                    new CatalogoProductoDTO(
                            1L, "Mouse inalámbrico Logitech M185", "Mouse compacto con conexión USB inalámbrica", 5499.00,
                            1L, "Computación", "Tecnología para el trabajo y el hogar",
                            101L, 100L, 10L
                    ),
                    new CatalogoProductoDTO(
                            2L, "Teclado mecánico Redragon Kumara", "Teclado gamer con retroiluminación LED RGB", 18999.00,
                            1L, "Computación", "Tecnología para el trabajo y el hogar",
                            102L, 50L, 5L
                    ),

                    // Fotografía (ID: 2L)
                    new CatalogoProductoDTO(
                            3L, "Cámara réflex Canon EOS Rebel T7", "Cámara DSLR con lente 18-55mm incluida", 239999.00,
                            2L, "Fotografía", "Equipos y accesorios para fotografía profesional y amateur",
                            103L, 20L, 2L
                    ),
                    new CatalogoProductoDTO(
                            4L, "Trípode Fotopro DIGI-3400", "Trípode liviano para cámaras compactas y réflex", 12999.00,
                            2L, "Fotografía", "Equipos y accesorios para fotografía profesional y amateur",
                            104L, 75L, 10L
                    ),

                    // Cafetería Espresso (ID: 3L)
                    new CatalogoProductoDTO(
                            5L, "Cafetera Nespresso Essenza Mini", "Cafetera automática de cápsulas con diseño compacto", 74999.00,
                            3L, "Cafetería Espresso", "Cafeteras, accesorios y productos relacionados con el café",
                            105L, 40L, 5L
                    ),
                    new CatalogoProductoDTO(
                            6L, "Molino de café manual Hario", "Molino con muelas de cerámica ajustables para café espresso", 21999.00,
                            3L, "Cafetería Espresso", "Cafeteras, accesorios y productos relacionados con el café",
                            106L, 30L, 3L
                    )
            );

            for (CatalogoProductoDTO producto : catalogoInicial) {
                CatalogoProductoDTO creado = catalogoService.createProducto(producto);
                System.out.println("Producto creado: " + creado);
            }

            System.out.println("Datos iniciales cargados correctamente.");
        };
    }

}

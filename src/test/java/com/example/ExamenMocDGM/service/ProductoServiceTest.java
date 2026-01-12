package com.example.ExamenMocDGM.service;

import com.example.ExamenMocDGM.entity.Producto;
import com.example.ExamenMocDGM.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {
    @Mock
    ProductoRepository productoRepository;
    @InjectMocks
    ProductoServiceImpl servicio;

    @Test
    void findAllProductos() {

    }

    @Test
    void findByPrecioAndCategoria() {
        Producto productoEsperado = new Producto();
        Mockito.when(productoRepository.findById(1L)).thenReturn(Optional.of(productoEsperado));
        Optional<Producto> resultado = servicio.findProducto(1L);
        if (resultado.isPresent()) {
            assertEquals(productoEsperado, resultado.get());
        }
        Mockito.verify(productoRepository).findById(1L);
    }

    @Test
    void addProducto() {
    }
}
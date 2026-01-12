package com.example.ExamenMocDGM.controller;

import com.example.ExamenMocDGM.entity.Producto;
import com.example.ExamenMocDGM.repository.ProductoRepository;
import com.example.ExamenMocDGM.service.ProductoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ProductoControllerTestMokito {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl service;

    @Test
    void getProductos() {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Test producto");

        Mockito.when(productoRepository.findById(1L)).thenReturn(Optional.of(producto));


        Optional<Producto> resultado = service.findProducto(1L);


        assertEquals(producto, resultado.get());

        Mockito.verify(productoRepository, Mockito.times(1)).findById(1L);
    }
}
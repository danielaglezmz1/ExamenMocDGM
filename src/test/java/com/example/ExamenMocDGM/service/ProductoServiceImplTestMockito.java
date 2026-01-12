package com.example.ExamenMocDGM.service;

import com.example.ExamenMocDGM.entity.Producto;
import com.example.ExamenMocDGM.repository.ProductoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceImplTestMockito {
    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAllProductos() {
        Producto p = new Producto();
        p.setId(1L);
        p.setNombre("Test");
        when(productoRepository.findById(1L)).thenReturn(Optional.of(p));

        Optional<Producto> result = productoService.findProducto(1L);

        assertNotNull(result);
        assertEquals("Test", result.get().getNombre());
        verify(productoRepository, times(1)).findById(1L);
    }
}
package com.example.ExamenMocDGM.service;

import com.example.ExamenMocDGM.entity.Producto;

import java.util.*;

public interface ProductoService {

    List<Producto> findAllProductos();
    Optional<Producto> findProducto(Long id);
    List<Producto> findByCategoria(String categoria);
    List<Producto> findByPrecio(float precio);

    List<Producto> findByPrecioAndCategoria(float precio, String categoria);

    Producto addProducto(Producto producto);
    void eliminarProductoById(Long productoId);
    Producto modificarProducto(Long productoId, Producto producto);

}

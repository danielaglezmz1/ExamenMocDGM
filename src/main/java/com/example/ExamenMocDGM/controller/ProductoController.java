package com.example.ExamenMocDGM.controller;

import com.example.ExamenMocDGM.entity.Producto;
import com.example.ExamenMocDGM.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping(value = "/productos")
    public Producto addProducto(@RequestBody Producto producto) {
        return this.productoService.addProducto(producto);
    }

    @DeleteMapping(value = "/producto/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        this.productoService.eliminarProductoById(productoId);
    }

    @PutMapping(value = "/producto/{productoId}")
    public Producto modificarProducto(@PathVariable Long productoId, @RequestBody Producto producto) {
        return this.productoService.modificarProducto(productoId, producto);
    }

    @GetMapping(value = "/productos")
    public List<Producto> getProductos(@RequestParam(defaultValue = "0.0") Float precio,
                                       @RequestParam(defaultValue = "") String categoria) {

        //  - Si no se indica ni precio ni categoría -> obtener todos los productos.
        if (precio == 0.0 && Objects.equals(categoria, "")) {
            return this.productoService.findAllProductos();
        } else if (Objects.equals(categoria, "")) {   //- Si se indica el precio -> obtener los productos con ese precio.
           return productoService.findByPrecio(precio);
        } else{ //- Si se indica la categoria -> obtener los productos con esa categoria.
            return  this.productoService.findByCategoria(categoria);
        }
    }

    @GetMapping(value = "/producto/{productoId}")
    public Optional<Producto> getProducto(@PathVariable Long productoId) {
        return this.productoService.findProducto(productoId);
    }

}
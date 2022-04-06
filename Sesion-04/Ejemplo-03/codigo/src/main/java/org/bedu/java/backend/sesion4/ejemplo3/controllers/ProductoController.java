package org.bedu.java.backend.sesion4.ejemplo3.controllers;

import org.bedu.java.backend.sesion4.ejemplo3.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @GetMapping(value = "/{productoId}")
    public ResponseEntity<Producto> getProducto(@PathVariable long productoId){
        Producto producto = new Producto();
        producto.setNombre("nombre del producto");
        producto.setId(productoId);
        producto.setPrecio(1.00f);

        return ResponseEntity.ok(producto);
    }
}

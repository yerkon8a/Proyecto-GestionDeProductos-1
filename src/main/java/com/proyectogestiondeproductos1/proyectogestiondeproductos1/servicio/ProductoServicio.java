package com.proyectogestiondeproductos1.proyectogestiondeproductos1.servicio;

import com.proyectogestiondeproductos1.proyectogestiondeproductos1.modelo.Producto;
import com.proyectogestiondeproductos1.proyectogestiondeproductos1.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> listAll(String palabraClave){
        if(palabraClave != null){
        return productoRepositorio.findAll(palabraClave);
        }
        return productoRepositorio.findAll();
    }
    public void save(Producto producto){
        productoRepositorio.save(producto);
    }

    public Producto get(long id){
        return productoRepositorio.findById(id).get();
    }

    public void delete(long id){
        productoRepositorio.deleteById(id);
    }

}

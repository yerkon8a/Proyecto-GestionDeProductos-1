package com.proyectogestiondeproductos1.proyectogestiondeproductos1.controlador;

import com.proyectogestiondeproductos1.proyectogestiondeproductos1.modelo.Producto;
import com.proyectogestiondeproductos1.proyectogestiondeproductos1.repositorio.ProductoRepositorio;
import com.proyectogestiondeproductos1.proyectogestiondeproductos1.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @RequestMapping("/")
    public String verPaginaInicio(Model modelo, @Param("palabraClave") String palabraClave) {
        List<Producto> listaProductos = productoServicio.listAll(palabraClave);


        modelo.addAttribute("listaProductos" , listaProductos);
        modelo.addAttribute("palabraClave", palabraClave);
        return "index";
    }

    @RequestMapping("/nuevo")
    public String formularioRegistro(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto" , producto);
        return "nuevo_producto";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoServicio.save(producto);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView formularioEditarRegistro(@PathVariable(name = "id")Long id) {
        ModelAndView modelo = new ModelAndView("editar_producto");

        Producto producto = productoServicio.get(id);
        modelo.addObject("producto" , producto);
        return modelo;
    }

    @RequestMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable(name = "id")Long id) {
        productoServicio.delete(id);
        return "redirect:/";
    }
}


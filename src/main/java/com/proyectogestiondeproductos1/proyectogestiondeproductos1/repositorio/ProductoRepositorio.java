package com.proyectogestiondeproductos1.proyectogestiondeproductos1.repositorio;

import com.proyectogestiondeproductos1.proyectogestiondeproductos1.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE CONCAT(p.id, p.nombre, p.marca, p.hechoEn, p.precio) LIKE %?1% ORDER BY p.id DESC")

    public List<Producto> findAll(String palabraClave);
}


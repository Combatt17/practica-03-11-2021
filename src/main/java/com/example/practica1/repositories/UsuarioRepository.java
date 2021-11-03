package com.example.practica1.repositories;

import java.util.ArrayList;

import com.example.practica1.models.UsuarioModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long>{
    
    public abstract UsuarioModel findByNombre(String nombre); 
}

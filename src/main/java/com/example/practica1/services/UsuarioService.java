package com.example.practica1.services;

import java.util.*;

import com.example.practica1.models.UsuarioModel;
import com.example.practica1.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;


    public ArrayList<UsuarioModel> getUsuarios(){
        return(ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel setUsuario(UsuarioModel usuario){
      return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> getUsuarioId(Long id){
      return usuarioRepository.findById(id);
    } 

    public UsuarioModel getUsuarioNombre (String nombre){
      return usuarioRepository.findByNombre(nombre);
    } 


    public boolean eliminarUsuario(Long id){
      try {
        usuarioRepository.deleteById(id);
        return true;
      } catch (Exception e) {
       System.out.println(e);
       return false;
      }
    }
}

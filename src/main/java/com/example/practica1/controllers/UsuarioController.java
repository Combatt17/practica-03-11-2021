package com.example.practica1.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.practica1.models.UsuarioModel;
import com.example.practica1.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;


    @GetMapping
    public ArrayList<UsuarioModel> traerUsuarios(){
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
         return usuarioService.setUsuario(usuario);
    }

    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> traerId(@PathVariable("id") Long id){
        return usuarioService.getUsuarioId(id);

    }


    @GetMapping(path = "/{nombre}")
    public UsuarioModel traerNombre(@PathVariable("nombre") String nombre){
        return usuarioService.getUsuarioNombre(nombre);

    }


    @DeleteMapping(path = "/{id}")
    public String eliminar(@PathVariable("id") Long id){
        boolean ok= this.usuarioService.eliminarUsuario(id);

        if(ok){
       return "El usuario fue eliminado";
        }else{
        return "Ocurrió un error al eliminar";
        }

    }

    
}

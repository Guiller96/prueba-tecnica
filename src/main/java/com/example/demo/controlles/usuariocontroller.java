package com.example.demo.controlles;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.usuariomedel;
import com.example.demo.services.usuarioservice;

public class usuariocontroller {
    
    @RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    usuarioservice usuarioService;

    /**
     * @return
     */
    @GetMapping()
    public ArrayList<usuariomedel> obtenerUsuarios(){
        return usuarioservice.obtenerUsuarios();
    }

    /**
     * @param usuario
     * @return
     */
    @PostMapping()
    public usuariomedel guardarUsuario(@RequestBody usuariomedel usuario){
        return this.usuarioService.guardarUsuario(usuario);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping( path = "/{id}")
    public Optional<usuariomedel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    /**
     * @param prioridad
     * @return
     */
    @GetMapping("/query")
    public ArrayList<usuariomedel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.usuarioService.eliminarUsuario(id);
        if (ok){
            return "Se eliminó el usuario con id " + id;
        }else{
            return "No pudo eliminar el usuario con id" + id;
        }
    }
}
}

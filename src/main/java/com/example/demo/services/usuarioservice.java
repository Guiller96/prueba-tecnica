package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.usuariomedel;
import com.example.demo.repositores.usuariorepository;

@Service
public class usuarioservice {
    /**
     *
     */
    @Autowired
    static
    usuariorepository usuarioRepository;
    
    public static ArrayList<usuariomedel> obtenerUsuarios(){
        return (ArrayList<usuariomedel>) usuarioRepository.findAll();
    }

    public usuariomedel guardarUsuario(usuariomedel usuario){
        return usuarioRepository.save(usuario);
    }

    public Optional<usuariomedel> obtenerPorId(Long id){
        return usuarioRepository.findById(id);
    }


    /**
     * @param prioridad
     * @return
     */
    public ArrayList<usuariomedel>  obtenerPorPrioridad(Integer prioridad) {
        return usuariorepository.findByPrioridad(prioridad);
    }

    /**
     * @param id
     * @return
     */
    public boolean eliminarUsuario(Long id) {
        try{
            usuariorepository.DeleteMapping(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}

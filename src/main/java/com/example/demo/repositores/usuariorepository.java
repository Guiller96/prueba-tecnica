package com.example.demo.repositores;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.usuariomedel;

@Repository
public interface usuariorepository extends CrudRepository<usuariomedel, Long> {
    
    public static ArrayList<usuariomedel> findByPrioridad(Integer prioridad) {
        return null;
    }

    static void DeleteMapping(Long id) {
    }
    
}

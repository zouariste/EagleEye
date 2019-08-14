package com.project.repositories;

import java.util.List;

import com.project.entities.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepository extends CrudRepository<Request, Integer> {
    List<Request> findAllById(Long id);
    

}

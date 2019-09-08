package com.project.repositories;

import java.util.List;
import com.project.entities.Business;
import org.springframework.data.repository.CrudRepository;

public interface BusinessRepository extends CrudRepository<Business, Integer> {
    List<Business> findAllById(Long id);
    

}

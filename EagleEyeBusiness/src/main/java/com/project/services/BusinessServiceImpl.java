package com.project.services;

import com.project.entities.Business;
import com.project.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Business service implement.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    private BusinessRepository BusinessRepository;

    @Autowired
    public void setBusinessRepository(BusinessRepository BusinessRepository) {
        this.BusinessRepository = BusinessRepository;
    }

    @Override
    public Iterable<Business> listAllBusinesss() {
        return BusinessRepository.findAll();
    }

    @Override
    public Business getBusinessById(Integer id) {
        Business l=BusinessRepository.findById(id)
        .orElse(null);
        
        return l;
        
    }

    @Override
    public Business saveBusiness(Business Business) {
        return BusinessRepository.save(Business);
    }

    @Override
    public void deleteBusiness(Integer id) {
        BusinessRepository.deleteById(id);
    }

   

}

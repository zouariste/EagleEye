package com.project.services;

import com.project.entities.Business;

public interface BusinessService {

    Iterable<Business> listAllBusinesss();

    Business getBusinessById(Integer id);

    Business saveBusiness(Business Business);

    void deleteBusiness(Integer id);

}

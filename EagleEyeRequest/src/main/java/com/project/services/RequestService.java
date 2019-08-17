package com.project.services;

import com.project.entities.Request;

public interface RequestService {

    Iterable<Request> listAllRequests();

    Request getRequestById(Integer id);

    Request saveRequest(Request request);

    void deleteRequest(Integer id);

    void visualizeRequest(Request request);

}

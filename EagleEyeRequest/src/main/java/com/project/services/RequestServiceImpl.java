package com.project.services;



import com.project.entities.Request;
import com.project.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Request service implement.
 */
@Service
public class RequestServiceImpl implements RequestService {

    private RequestRepository requestRepository;

    @Autowired
    public void setRequestRepository(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Iterable<Request> listAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Request getRequestById(Integer id) {
        Request l=requestRepository.findById(id)
        .orElse(null);
        
        return l;
        
    }

    @Override
    public Request saveRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public void deleteRequest(Integer id) {
        requestRepository.deleteById(id);
    }

}

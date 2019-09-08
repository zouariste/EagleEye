package com.project.controllers;

import java.util.Calendar;
import java.util.Date;
import com.project.entities.Request;
import com.project.services.RequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Request controller.
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RequestController {

    private RequestService requestService;
    @Autowired
    private KafkaTemplate<String, Request> kafkaTemplate;

    @Autowired
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

    /**
     * List all requests.
     *
     * @param model
     * @return
     */   
    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("requests", requestService.listAllRequests());
        System.out.println("Returning rpoducts:");
        return "requests";
    }

    /**
     * View a specific request by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("request/{id}")
    public String showRequest(@PathVariable Integer id, Model model) {
        model.addAttribute("request", requestService.getRequestById(id));
        return "requestshow";
    }

    // Afficher le formulaire de modification du Request
    @RequestMapping("request/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("request", requestService.getRequestById(id));
        return "requestform";
    }

    /**
     * New request.
     *
     * @param model
     * @return
     */
    @RequestMapping("request/new")
    public String newRequest(Model model) {
        try {
            model.addAttribute("request", new Request());
            return "requestform";
          }
          catch(Exception e) {
            //  Block of code to handle errors
          }
          return "";
    }

    /**
     * Save request to database.
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "request", method = RequestMethod.POST)
    public String saveRequest(Request request) {
        requestService.saveRequest(request);
        return "redirect:/request/" + request.getId();
    }

    /**
     * Delete request by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("request/delete/{id}")
    public String delete(@PathVariable Integer id) {
        requestService.deleteRequest(id);
        return "redirect:/requests";
    }

    /**
     * Dashbords
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String list2(Model model) {
        model.addAttribute("requests", requestService.listAllRequests());
        System.out.println("Returning rpoducts:");
        return "dashboards";
    }



       /**
     * Visualize request by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("request/visualize/{id}")
    public String visualize(@PathVariable Integer id,  Model model) {
        String TOPIC = "visualizer";
        Request r=requestService.getRequestById(id);
        System.out.println(r.getLanguages());
        Date date = Calendar.getInstance().getTime();
        r.setDateexe(date);
        requestService.saveRequest(r);
        kafkaTemplate.send(TOPIC,requestService.getRequestById(id));
        model.addAttribute("request", requestService.getRequestById(id));
        return "dashbord";
    }

    
    
    
}

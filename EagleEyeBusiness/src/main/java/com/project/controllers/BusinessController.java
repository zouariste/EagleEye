package com.project.controllers;

import com.project.entities.Business;
import com.project.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Business controller.
 */
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BusinessController {

    private BusinessService businessService;

    @Autowired
    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    /**
     * List all businesss.
     *
     * @param model
     * @return
     */   
    @RequestMapping(value = "/businesss", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("businesss", businessService.listAllBusinesss());
        return "businesss";
    }

    /**
     * View a specific business by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("business/{id}")
    public String showBusiness(@PathVariable Integer id, Model model) {
        model.addAttribute("business", businessService.getBusinessById(id));
        return "businessshow";
    }

    // Afficher le formulaire de modification du Business
    @RequestMapping("business/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("business", businessService.getBusinessById(id));
        return "businessform";
    }

    /**
     * New business.
     *
     * @param model
     * @return
     */
    @RequestMapping("business/new")
    public String newBusiness(Model model) {
        try {
            model.addAttribute("business", new Business());
            return "businessform";
          }
          catch(Exception e) {
            //  Block of code to handle errors
          }
          return "";
    }

    /**
     * Save business to database.
     *
     * @param business
     * @return
     */
    @RequestMapping(value = "business", method = RequestMethod.POST)
    public String saveBusiness(Business business) {
        businessService.saveBusiness(business);
        return "redirect:/business/" + business.getId();
    }

    /**
     * Delete business by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("business/delete/{id}")
    public String delete(@PathVariable Integer id) {
        businessService.deleteBusiness(id);
        return "redirect:/businesss";
    }
    
}

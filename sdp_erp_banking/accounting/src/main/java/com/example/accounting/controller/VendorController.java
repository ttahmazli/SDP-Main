package com.example.accounting.controller;

import com.example.accounting.model.Vendor;
import com.example.accounting.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendorController {

    @Autowired
    VendorService vendorService;

    @GetMapping("/vendors")
    public String viewVendorPage(Model model) {
        model.addAttribute("listVendors", vendorService.getAllVendors());
        return "vendors";
    }

    @GetMapping("/addVendor")
    public String showNewVendorForm(Model model) {
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        return "addVendor";
    }

    @PostMapping("/saveVendor")
    public String saveVendor(@ModelAttribute("vendor") Vendor vendor) {
        this.vendorService.saveVendor(vendor);
        return "redirect:/vendors";
    }

    @GetMapping("/editVendor/{id}")
    public String showVendorUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Vendor vendor = vendorService.getVendorById(id);
        model.addAttribute("vendor", vendor);
        return "editVendor";
    }

    @GetMapping("/deleteVendor/{id}")
    public String deleteVendor(@PathVariable(value  = "id") long id) {
        this.vendorService.deleteVendorById(id);
        return "redirect:/vendors";
    }
}

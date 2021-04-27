package com.example.accounting.controller;

import com.example.accounting.model.Bill;
import com.example.accounting.model.Vendor;
import com.example.accounting.service.BillService;
import com.example.accounting.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class BillController {

    @Autowired
    private BillService billService;

    @Autowired
    private VendorService vendorService;

    @GetMapping("/index")
    public String viewHomePage() {
        return "index";
    }

    @GetMapping("/bills")
    public String viewBillPage(Model model) {
        model.addAttribute("listBills", billService.getAllBills());
        return "bills";
    }

    @GetMapping("addBill")
    public String showNewBillForm(Model model) {
        Bill bill = new Bill();
        model.addAttribute("bill", bill);

        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        model.addAttribute("listVendors", vendorService.getAllVendors());

        return "addBill";
    }

    @PostMapping("/saveBill")
    public String saveBill(@ModelAttribute("bill") Bill bill) {
        this.billService.saveBill(bill);
        return "redirect:/bills";
    }

    @GetMapping("/editBill/{id}")
    public String showBillUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Bill bill = billService.getBillById(id);
        model.addAttribute("bill", bill);

        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        model.addAttribute("listVendors", vendorService.getAllVendors());

        return "editBill";
    }

    @GetMapping("/deleteBill/{id}")
    public String deleteBill(@PathVariable(value = "id") long id) {
        this.billService.deleteBillById(id);
        return "redirect:/bills";
    }
}


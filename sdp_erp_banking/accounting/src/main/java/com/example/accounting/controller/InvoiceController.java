package com.example.accounting.controller;

import com.example.accounting.model.Invoice;
import com.example.accounting.service.InvoiceService;
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
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/invoices")
    public String viewInvoicePage(Model model) {
        model.addAttribute("listInvoices", invoiceService.getAllInvoices());
        return "invoices";
    }

    @GetMapping("addInvoice")
    public String showNewInvoiceForm(Model model) {
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "addInvoice";
    }

    @PostMapping("/saveInvoice")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        this.invoiceService.saveInvoice(invoice);
        return "redirect:/invoices";
    }

    @GetMapping("/editInvoice/{id}")
    public String showInvoiceUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "editInvoice";
    }

    @GetMapping("/deleteInvoice/{id}")
    public String deleteInvoice(@PathVariable(value = "id") long id) {
        this.invoiceService.deleteInvoiceById(id);
        return "redirect:/invoices";
    }
}


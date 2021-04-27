package com.example.accounting.service;

import java.util.List;
import java.util.Optional;

import com.example.accounting.model.Invoice;
import com.example.accounting.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceImp implements InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Override
    public List<Invoice> getAllInvoices() {

        return invoiceRepository.findAll();
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        this.invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(long id) {
        Optional<Invoice> optional = this.invoiceRepository.findById(id);
        Invoice invoice = null;
        if (optional.isPresent()) {
            invoice = optional.get();
        } else {
            throw new RuntimeException("Invoice couldn't be found with give ID: " + id);
        }

        return invoice;
    }

    @Override
    public void deleteInvoiceById(long id) {
        this.invoiceRepository.deleteById(id);

    }
}



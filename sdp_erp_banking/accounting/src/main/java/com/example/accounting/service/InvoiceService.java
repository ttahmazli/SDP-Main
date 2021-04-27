package com.example.accounting.service;

import com.example.accounting.model.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();

    void saveInvoice(Invoice invoice);

    Invoice getInvoiceById(long id);

    void deleteInvoiceById(long id);
}

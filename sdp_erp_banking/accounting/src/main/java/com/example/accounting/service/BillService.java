package com.example.accounting.service;

import com.example.accounting.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAllBills();

    void saveBill(Bill bill);

    Bill getBillById(long id);

    void deleteBillById(long id);
}

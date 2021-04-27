package com.example.accounting.service;

import java.util.List;
import java.util.Optional;


import com.example.accounting.model.Bill;
import com.example.accounting.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BillServiceImp implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> getAllBills() {

        return billRepository.findAll();
    }

    @Override
    public void saveBill(Bill bill) {
        this.billRepository.save(bill);
    }

    @Override
    public Bill getBillById(long id) {
        Optional<Bill> optional = this.billRepository.findById(id);
        Bill bill = null;
        if (optional.isPresent()) {
            bill = optional.get();
        } else {
            throw new RuntimeException("Bill couldn't be found with give ID: " + id);
        }

        return bill;
    }

    @Override
    public void deleteBillById(long id) {
        this.billRepository.deleteById(id);

    }
}



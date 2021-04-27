package com.example.accounting.service;

import com.example.accounting.model.Vendor;
import com.example.accounting.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImp implements VendorService {

    @Autowired
    VendorRepository vendorRepository;

    @Override
    public List<Vendor> getAllVendors() {

        return vendorRepository.findAll();
    }

    @Override
    public void saveVendor(Vendor vendor) {

        this.vendorRepository.save(vendor);
    }

    @Override
    public Vendor getVendorById(long id) {

        Optional<Vendor> optional = this.vendorRepository.findById(id);
        Vendor vendor = null;

        if (optional.isPresent())
            vendor = optional.get();
        else
            throw new RuntimeException("Vendor couldn't be found with given ID: " + id);

        return vendor;
    }

    @Override
    public void deleteVendorById(long id) {

        this.vendorRepository.deleteById(id);
    }
}

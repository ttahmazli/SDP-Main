package com.example.accounting.service;


import com.example.accounting.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAllVendors();

    void saveVendor(Vendor vendor);

    Vendor getVendorById(long id);

    void deleteVendorById(long id);
}

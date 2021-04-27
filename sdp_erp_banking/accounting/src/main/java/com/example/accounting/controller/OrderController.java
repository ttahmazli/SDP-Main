package com.example.accounting.controller;

import com.example.accounting.model.Order;
import com.example.accounting.model.Vendor;
import com.example.accounting.service.OrderService;
import com.example.accounting.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private VendorService vendorService;

    @GetMapping("/orders")
    public String viewVendorPage(Model model) {
        model.addAttribute("listOrders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/addOrder")
    public String showNewOrderForm(Model model) {
        Order order = new Order();
        model.addAttribute("order", order);

        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        model.addAttribute("listVendors", vendorService.getAllVendors());

        return "addOrder";
    }

    @PostMapping("/saveOrder")
    public String saveVendor(@ModelAttribute("order") Order order) {
        this.orderService.saveOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/editOrder/{id}")
    public String showOrderUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);

        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        model.addAttribute("listVendors", vendorService.getAllVendors());

        return "editOrder";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteVendor(@PathVariable(value = "id") long id) {
        this.orderService.deleteOrderById(id);
        return "redirect:/orders";
    }
}






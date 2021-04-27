package com.example.accounting.controller;

import com.example.accounting.model.Expense;
import com.example.accounting.service.ExpenseService;

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
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public String viewBillPage(Model model) {
        model.addAttribute("listExpenses", expenseService.getAllExpenses());
        return "expenses";
    }

    @GetMapping("/addExpense")
    public String showNewExpenseForm(Model model) {
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "addExpense";
    }

    @PostMapping("/saveExpense")
    public String saveExpense(@ModelAttribute("expense") Expense expense) {
        this.expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/editExpense/{id}")
    public String showExpenseUpdateForm(@PathVariable(value = "id") long id, Model model) {
        Expense expense = expenseService.getExpenseById(id);
        model.addAttribute("expense", expense);
        return "editExpense";
    }

    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable(value = "id") long id) {
        this.expenseService.deleteExpenseById(id);
        return "redirect:/expenses";
    }
}


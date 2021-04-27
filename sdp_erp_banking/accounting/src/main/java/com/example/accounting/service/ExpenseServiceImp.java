package com.example.accounting.service;

import java.util.List;
import java.util.Optional;

import com.example.accounting.model.Expense;
import com.example.accounting.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExpenseServiceImp implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {

        return expenseRepository.findAll();
    }

    @Override
    public void saveExpense(Expense expense) {
        this.expenseRepository.save(expense);
    }

    @Override
    public Expense getExpenseById(long id) {
        Optional<Expense> optional = this.expenseRepository.findById(id);
        Expense expense = null;
        if (optional.isPresent()) {
            expense = optional.get();
        } else {
            throw new RuntimeException("Expense couldn't be found with give ID: " + id);
        }

        return expense;
    }

    @Override
    public void deleteExpenseById(long id) {
        this.expenseRepository.deleteById(id);

    }
}



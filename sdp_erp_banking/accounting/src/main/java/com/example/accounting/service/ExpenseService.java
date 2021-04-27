package com.example.accounting.service;

import com.example.accounting.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> getAllExpenses();

    void saveExpense(Expense expense);

    Expense getExpenseById(long id);

    void deleteExpenseById(long id);
}

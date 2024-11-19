package com.exus.expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exus.expensetracker.model.Expense;
import com.exus.expensetracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired ExpenseService expenseService;

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense){
        return expenseService.createExpense(expense);
    }

    @GetMapping
    public List<Expense> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("{/id}")
    public Expense getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expenseDetails){
        return expenseService.updateExpense(id, expenseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }

}

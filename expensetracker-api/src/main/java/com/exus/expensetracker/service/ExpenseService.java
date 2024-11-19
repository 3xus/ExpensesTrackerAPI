package com.exus.expensetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exus.expensetracker.model.Expense;
import com.exus.expensetracker.repository.ExpenseRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Creación de un registro de gasto
    public Expense createExpense(Expense expense){
        return expenseRepository.save(expense);
    }

    // Búsqueda y retorno de la lista de todos los gastos registrados
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    // Búsqueda de gastos por Id
    public Expense getExpenseById(Long id){
        return expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Expense not found with id: "+ id));
    }

    // Actualización del registro de un Gasto
    public Expense updateExpense(Long id, Expense expenseDetails){
        Expense expense = getExpenseById(id);
        expense.setCategory(expenseDetails.getCategory());
        expense.setAmount(expenseDetails.getAmount());
        expense.setDate(expenseDetails.getDate());
        return expenseRepository.save(expense);
    }

    // Eliminación de un registro de gasto
    public void deleteExpense(Long id){
        Expense expense = getExpenseById(id);
        expenseRepository.delete(expense);
    }

}

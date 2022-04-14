package com.americao.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.americao.safetravels.models.Expense;
import com.americao.safetravels.repositories.ExpenseRepo;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepo expenseRepo;
	
//	 Read All
	public List<Expense> allExpenses(){
		return expenseRepo.findAll();
	}
	
//	Create
	public Expense createExpense(Expense e) {
		return expenseRepo.save(e);
	}
// retrieves a book
		public Expense findExpense(Long id) {
	     Optional<Expense> optionalExpense = expenseRepo.findById(id);
	     if(optionalExpense.isPresent()) {
	         return optionalExpense.get();
	     } else {
	         return null;
	     }
	 }
//	Update Render
		public Expense updateExpense(Expense e) {
		    return expenseRepo.save(e);
		}

//	Delete
	public void destroy(Long id) {
		expenseRepo.deleteById(id);
	}
}

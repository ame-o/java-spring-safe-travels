package com.americao.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.americao.bookapi.models.Book;
import com.americao.safetravels.models.Expense;
import com.americao.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
//	dependency injection to use Service here
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
//	Display All but also Create New One
	@GetMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("allExpenses",allExpenses);
		return "index.jsp";
	}
//	Display One
	@GetMapping("/expenses/{id}")
	public String displayOne(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense",expense);
		return "show.jsp";
	}	     
	 
//	process create one
	@PostMapping("/expenses/new")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	     if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            expenseService.createExpense(expense);
	            return "redirect:/expenses";
	        }
	}
//	update / render
	@RequestMapping("/expenses/edit/{id}")
	public String editRender(@PathVariable("id")Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense",expense);
		return "edit.jsp";
	}
//  update / process
	@PutMapping("/expenses/edit/process/{id}")
	public String editProcess(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
	     if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	            expenseService.createExpense(expense);
	            return "redirect:/expenses/edit/{id}";
	        }
	}
	
//	delete
    @DeleteMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expenseService.destroy(id);
        return "redirect:/expenses";
    }

}

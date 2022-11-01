package lt.viko.eif.vytzab.expenseTrackerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.Expense;
import lt.viko.eif.vytzab.expenseTrackerApi.service.IExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private IExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
}

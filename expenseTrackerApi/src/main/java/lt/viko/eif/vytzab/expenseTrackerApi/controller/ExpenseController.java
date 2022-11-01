package lt.viko.eif.vytzab.expenseTrackerApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable Long id) {
		return expenseService.getExpenseById(id);
	}

	@DeleteMapping("/expenses/{id}")
	public void deleteExpenseById(@PathVariable Long id) {
		expenseService.deleteExpenseById(id);
	}

	@PostMapping("/expenses")
	public Expense saveExpense(@RequestBody Expense expense) {
		return expenseService.saveExpense(expense);
	}

	@PutMapping("/expenses/{id}")
	public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
		return expenseService.updateExpense(id, expense);
	}
}

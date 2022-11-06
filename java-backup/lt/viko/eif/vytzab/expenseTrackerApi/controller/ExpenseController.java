package lt.viko.eif.vytzab.expenseTrackerApi.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.Expense;
import lt.viko.eif.vytzab.expenseTrackerApi.service.IExpenseService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ExpenseController {

	@Autowired
	private IExpenseService expenseService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense createExpense(@Valid @RequestBody Expense expense) {
		return expenseService.createExpense(expense);
	}

	@GetMapping("/expenses")
	public List<Expense> getExpenses(Pageable page) {
		return expenseService.getExpenses(page).toList();
	}

	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable Long id) {
		return expenseService.getExpenseById(id);
	}

	@PutMapping("/expenses/{id}")
	public Expense updateExpense(@RequestBody Expense expense, @PathVariable Long id) {
		return expenseService.updateExpense(id, expense);
	}

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses/{id}")
	public void deleteExpenseById(@PathVariable Long id) {
		expenseService.deleteExpenseById(id);
	}

	@GetMapping("/expenses/category")
	public List<Expense> getExpensesByCategory(@RequestParam String category, Pageable page) {
		return expenseService.readByCategory(category, page);
	}

	@GetMapping("/expenses/name")
	public List<Expense> getExpensesByName(@RequestParam String keyword, Pageable page) {
		return expenseService.readByName(keyword, page);
	}

	@GetMapping("/expenses/date")
	public List<Expense> getExpensesByDate(@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate, Pageable page) {
		return expenseService.readByDate(startDate, endDate, page);
	}
}

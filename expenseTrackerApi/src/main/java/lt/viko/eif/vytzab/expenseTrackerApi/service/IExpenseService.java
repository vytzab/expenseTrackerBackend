/**
 * 
 */
package lt.viko.eif.vytzab.expenseTrackerApi.service;

import java.util.List;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.Expense;

/**
 * @author Vytautas
 *
 */
public interface IExpenseService {

	List<Expense> getAllExpenses();

	Expense getExpenseById(Long id);

	void deleteExpenseById(Long id);
	
	Expense saveExpense(Expense expense);
	
	Expense updateExpense(Long id, Expense expense);
}

/**
 * 
 */
package lt.viko.eif.vytzab.expenseTrackerApi.service;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.Expense;

/**
 * @author Vytautas
 *
 */
public interface IExpenseService {

	Page<Expense> getAllExpenses(Pageable page);

	Expense getExpenseById(Long id);

	void deleteExpenseById(Long id);

	Expense saveExpense(Expense expense);

	Expense updateExpense(Long id, Expense expense);
	
	List<Expense> readByCategory(String category, Pageable page);
	
	List<Expense> readByName(String name, Pageable page);
	
	List<Expense> readByDate(Date startDate, Date endDate, Pageable page);
}

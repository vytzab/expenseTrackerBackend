package lt.viko.eif.vytzab.expenseTrackerApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.viko.eif.vytzab.expenseTrackerApi.entity.Expense;
import lt.viko.eif.vytzab.expenseTrackerApi.repository.IExpenseRepository;

@Service
public class ExpenseServiceImpl implements IExpenseService {
	
	@Autowired
	private IExpenseRepository expenseRepo;

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

}

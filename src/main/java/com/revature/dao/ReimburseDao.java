package com.revature.dao;

import java.util.List;

import com.revature.model.Reimburse;

public interface ReimburseDao {

	List<Reimburse> getAllTodosByUsername(String username);
	Reimburse createTodo(Reimburse todo, String username);
}

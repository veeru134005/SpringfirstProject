package com.app.service;

import java.util.List;

public interface Services<T> {

	<T> List<T> find (T newEntity);
	<T> int update(T type);
	
}

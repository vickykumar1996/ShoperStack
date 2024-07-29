package com.edu.jsp.dao;

import java.util.List;
import java.util.Optional;

import com.edu.jsp.entity.Cart;

public interface CartDao {

	Cart saveCart(Cart cart);

	List<Cart> findAll();

	Optional<Cart> findById(int cartId);

	void delete(int cartId);

	boolean isPresent(int cartId);
}
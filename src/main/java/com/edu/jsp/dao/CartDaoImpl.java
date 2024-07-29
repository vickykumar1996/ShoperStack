package com.edu.jsp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.edu.jsp.entity.Cart;
import com.edu.jsp.repository.CartRepositoty;

@Repository
public class CartDaoImpl implements CartDao {
	@Autowired
	private CartRepositoty cartRepositoty;

	@Override
	public Cart saveCart(Cart cart) {
		return cartRepositoty.save(cart);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepositoty.findAll();
	}

	@Override
	public Optional<Cart> findById(int cartId) {
		return cartRepositoty.findById(cartId);
	}

	@Override
	public void delete(int cartId) {
		cartRepositoty.deleteById(cartId);
	}

	@Override
	public boolean isPresent(int cartId) {
		return cartRepositoty.existsById(cartId);
	}

}
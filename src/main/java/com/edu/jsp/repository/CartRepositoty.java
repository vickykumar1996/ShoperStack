package com.edu.jsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.jsp.entity.Cart;

public interface CartRepositoty extends JpaRepository<Cart, Integer> {

}

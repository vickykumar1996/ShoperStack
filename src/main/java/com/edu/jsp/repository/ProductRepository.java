package com.edu.jsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.jsp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	void updateProductPrice(int productId, double productPrice);

}

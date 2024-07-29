package com.edu.jsp.dao;

import java.util.List;
import java.util.Optional;

import com.edu.jsp.entity.Product;

public interface ProductDao {
	Product saveProduct(Product product);

	Optional<Product> findById(int productId);

	List<Product> findAll();

	void deleteProduct(int productId);

	boolean isPresent(int productId);

	void updateProductPrice(int productId, double productPrice);
}
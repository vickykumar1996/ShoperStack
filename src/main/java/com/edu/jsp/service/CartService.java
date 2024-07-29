package com.edu.jsp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.jsp.dao.CartDao;
import com.edu.jsp.dao.ProductDao;
import com.edu.jsp.entity.Cart;
import com.edu.jsp.entity.Product;
import com.edu.jsp.util.ResponseStructure;

@Service
public class CartService {
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;

	public ResponseEntity<ResponseStructure<Cart>> saveCart(Cart cart, int productId) {

		Optional<Product> optional = productDao.findById(productId);
		if (optional.isPresent()) {

			List<Product> listOfProducts = cart.getProducts();

			if (listOfProducts == null) {
				listOfProducts = new ArrayList<Product>();
			}

			listOfProducts.add(optional.get());

			cart.setProducts(listOfProducts);

		}

		cart = calculatePriceOfCart(cart);
		Cart savedCart = cartDao.saveCart(cart);

		ResponseStructure<Cart> structure = new ResponseStructure<Cart>();
		structure.setMessage("Created");
		structure.setData(savedCart);
		return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.CREATED);
	}

	public Cart calculatePriceOfCart(Cart cart) {
		// Write a login to set the Number of Product and Total price
		if (cart.getProducts() != null) {

			// Calculate the Number of Product
			List<Product> listOfProducts = cart.getProducts();
			int numberOfProducts = listOfProducts.size();
			cart.setNumberOfPrducts(numberOfProducts);

			// Calculate the Total Price
			double totalPrice = 0.0;
			for (Product product : listOfProducts) {
				product.setCart(cart);
				totalPrice += product.getProductPrice();
			}
			cart.setTotalPrice(totalPrice);
		}
		return cart;
	
	}
}

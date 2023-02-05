package com.example.restclient;

import com.example.restclient.dto.CartLineDTO;
import com.example.restclient.dto.ProductDTO;
import com.example.restclient.dto.ShoppingcartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestclientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String productcatalog_serverUrl = "http://localhost:8080/products";
		String shopping_serverUrl = "http://localhost:8081/shoppingcarts";

		//add Product 1
		restTemplate.postForLocation(productcatalog_serverUrl, new ProductDTO(1,"Product 1 description by Win", 1000.00, 1));

		//get Product 1
		var product=restTemplate.getForObject(productcatalog_serverUrl+"/{productnumber}", ProductDTO.class, 1);;
		System.out.println("----------- get Product 1-----------------------");
		System.out.println(product.getProductNumber()+", "+product.getDescription()+", "+product.getPrice()+", "+product.getSupplierNumber());

		//add shopping cart 1
		List<CartLineDTO> cartLineDTOList=new ArrayList<CartLineDTO>();
		cartLineDTOList.add(new CartLineDTO(10, 1));
		restTemplate.postForLocation(shopping_serverUrl, new ShoppingcartDTO(1,cartLineDTOList));

		//get shopping cart 1
		var shoppingcart=restTemplate.getForObject(shopping_serverUrl+"/{shoppingcartNumber}", ShoppingcartDTO.class, 1);;
		var cartLines="";
		for (var cartLine: shoppingcart.getCartLineDTOs()) {
			cartLines+=cartLine.getProductNumber() + "- quantity : "+ cartLine.getQuantity();
		}
		System.out.println("----------- get Shopping Cart 1-----------------------");
		System.out.println(shoppingcart.getShoppingcardNumber()+", "+cartLines);

	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}

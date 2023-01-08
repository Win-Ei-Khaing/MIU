package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;

import java.util.List;

@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@GetMapping
	public String getProductForm(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "ProductForm";
	}

	@PostMapping
	public String saveProduct(Product product) {
		Category category = categoryService.getCategory(product.getCategory().getId());
		product.setCategory(category);
		product.setId(productService.getAll().size()+1); //as id is always saving with 0
		productService.save(product);
		return "ProductDetails";
	}

	@GetMapping("/listproducts")
	public String listProducts(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products", products);
		return "ListProducts";
	}

	@GetMapping("/productfind")
	public String findProduct() {
		return "Find";
	}

	@PostMapping("/productfind")
	public String findProduct(@RequestParam("id") String productId, Model model) {
		if(productId == null || productId.trim()=="") //checking input is null or empty
			return "Find";
		try { //just catching for String input for product id
			Product result = productService.getProductById(Long.parseLong(productId));
		model.addAttribute("product", result);
		return "SingleProduct";
		}
		catch (Exception e){
			return "Find";
		}
	}
}

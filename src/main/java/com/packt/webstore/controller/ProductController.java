package com.packt.webstore.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.service.ProductService;



@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	

  @RequestMapping
  public String list(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    return "products";
  }
  
  @RequestMapping("/{category}")
  public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
    model.addAttribute("products", productService.getProductsByCategory(productCategory));
    return "products";
  }
  
  @RequestMapping("/all")
  public String allProducts(Model model) {
    model.addAttribute("products", productService.getAllProducts());
    
  return "products";
  }
  
  @RequestMapping("/filter/{ByCriteria}")
  public String getProductsByFilter(@MatrixVariable(pathVar= "ByCriteria") Map<String,List<String>> filterParams,Model model) {
    model.addAttribute("products", productService.getProductsByFilter(filterParams));
    return "products";
  }
  
  @RequestMapping("/product")
  public String getProductById(@RequestParam("id") String productId, Model model) {
    model.addAttribute("product", productService.getProductById(productId));
    return "product";
  }
  
  
	/*  
	 * http://localhost:8080/webstore/products/tablet/price;low=200;high=400?manufacturer="Google"
		
	 * 
	 * Remember that this URL contains the matrix variables low and high to represent the price range, the GET parameter manufacturer to identify 
	  the manufacturer, and finally, a URI template path variable tablet to represent the category. */
 
  
}
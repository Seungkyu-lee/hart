package com.hart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hart.domain.CategoryVO;
import com.hart.domain.ProductsVO;
import com.hart.domain.ProductsVO2;
import com.hart.service.ProductsService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/product")
public class ProductsController {

	@Autowired
	private ProductsService productsservice;

	@GetMapping("/list")
	public String productlist(Model model, ProductsVO productsVO) {

		List<CategoryVO> category = null;
		List<ProductsVO> productlist = null;

		try {
			category = productsservice.getcategorybar();
			productlist=productsservice.getProductList(productsVO);
		} catch (Exception e) {

			e.printStackTrace();
		}
		model.addAttribute("category", category);
		model.addAttribute("productlist", productlist);
		return "product/productList";
	}
	
	
	@GetMapping("/listpage")
	public String productlistpage(Model model, ProductsVO2 cvo) {
		List<ProductsVO2> category = null;
		try {
			category = productsservice.getcategoryproducts(cvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "category";
	}

	
	@GetMapping("productDetail")
	public String ProductDtail() {
		
		
		
		
		
		return "product/productDetail";
		
	}
	
	
}

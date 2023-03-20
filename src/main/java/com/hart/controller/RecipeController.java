package com.hart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hart.domain.RecipeVO;
import com.hart.service.RecipeService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/recipe")
@Log4j2
public class RecipeController {

	@Autowired
	RecipeService recipeservice;
	
	
	@GetMapping("/list")
	public String recipelist(Model model) {
		try {
			
			List<RecipeVO> recipelist = recipeservice.recipelist();
			log.info("recipelist===" +recipelist);
			 model.addAttribute("recipelist", recipelist);
			 
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		return "/recipe/recipeList";
	}
	
	
	
	
	@GetMapping("/recipeDetail")
	public String recipedetail(String rid,Model model) {
		try {
			RecipeVO recipeDetail = recipeservice.recipeDetail(rid);
			
			model.addAttribute("recipeDetail", recipeDetail);
			
			System.out.println( "recipeDetail controller========>>"+recipeDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/recipe/recipeDetails";
	}
	
	
}

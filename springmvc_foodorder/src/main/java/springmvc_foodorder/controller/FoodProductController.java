package springmvc_foodorder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc_foodorder.dao.FoodProductDao;
import springmvc_foodorder.dao.MenuDao;
import springmvc_foodorder.dto.FoodProduct;
import springmvc_foodorder.dto.Menu;

@Controller
public class FoodProductController {
	@Autowired
	private FoodProductDao dao;
	@Autowired
	private MenuDao menuDao;
	
	@RequestMapping("/addfoodproduct")
	public ModelAndView add_foodproduct() {
		ModelAndView andView=new ModelAndView();
	
		andView.addObject("food", new FoodProduct());
		//andView.addObject("fp", new FoodProduct());
		andView.setViewName("savefoodproduct.jsp");
		return andView;
	}
	
	
	@RequestMapping("/savefoodproduct")
	public ModelAndView savefoodproduct(@ModelAttribute FoodProduct foodProduct) {
		ModelAndView andView=new ModelAndView();
		dao.saveFoodProduct(foodProduct);
		andView.setViewName("displayfoodproducts");
		return andView;
	}
	
	@RequestMapping("/displayfoodproducts")
	public ModelAndView showFoodProduct() {
		ModelAndView andView=new ModelAndView();
		List<FoodProduct> list=dao.getAllFoodProducts();
		andView.addObject("list",list);
		andView.setViewName("displayfoodproducts.jsp");
		return andView;	
		
	}
	@RequestMapping("/addtomenu")
	public ModelAndView addMenu(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		FoodProduct foodProduct=dao.getById(id);
		andView.addObject("food",foodProduct);
		andView.setViewName("addFoodToMenu.jsp");
		return andView;
	}
	@RequestMapping("/add")
	public ModelAndView add(@ModelAttribute FoodProduct foodProduct) {
		ModelAndView andView=new ModelAndView();
		int id=foodProduct.getMenu().getId();
		Menu menu=menuDao.getMenuById(id);
//	
//		List<FoodProduct> list= menu.getList();
//		list.add(foodProduct);
//		menu.setList(list);
		foodProduct.setMenu(menu);
		
		//menuDao.updateMenu(menu);
		//foodProduct.setMenu(menu);
		dao.updateFoodProduct(foodProduct);
		
		andView.setViewName("displayfoodproducts");
		return andView;	
	}
	@RequestMapping("/deletefood")
	public ModelAndView deleteFood(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		
		int id1=dao.deleteFood(id).getMenu().getId();
		List<FoodProduct> list=dao.getAllFoodProducts();
		List<FoodProduct> list2=new ArrayList<FoodProduct>();
		for(FoodProduct foodProduct:list)
		{
			if(foodProduct.getMenu().getId()==id1)
				list2.add(foodProduct);
		}
		andView.addObject("list",list2);
		andView.setViewName("menufoodproducts.jsp");
		return andView;
		
	}
	
	@RequestMapping("/updatefood")
	public ModelAndView updateFood(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		FoodProduct foodProduct=dao.getById(id);
		andView.addObject("food", foodProduct);
		andView.setViewName("updatefoodproductdetails.jsp");
		return andView;
		
	}
	@RequestMapping("/updatefoodproduct")
	public ModelAndView updateFoodDetails(@ModelAttribute FoodProduct food) {
		ModelAndView andView=new ModelAndView();
		int id=food.getId();
		FoodProduct foodProduct=dao.getById(id);
		Menu menu=foodProduct.getMenu();
		food.setMenu(menu);
		dao.updateFoodProduct(food);
		
		andView.setViewName("displayfoodproducts");
		return andView;
		
		
		
	}

}

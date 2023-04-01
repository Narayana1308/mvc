package springmvc_foodorder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springmvc_foodorder.dao.FoodProductDao;
import springmvc_foodorder.dao.MenuDao;
import springmvc_foodorder.dto.FoodProduct;
import springmvc_foodorder.dto.Menu;

@Controller
public class MenuController {
	@Autowired
	private MenuDao dao;
	
	@Autowired
	private FoodProductDao foodProductDao;

	@RequestMapping("/displayManager")
	public ModelAndView saveMenu() {
		ModelAndView andView=new ModelAndView();
		andView.addObject("menu", new Menu());
		andView.setViewName("savemenu.jsp");
		return andView;
	}
	@RequestMapping("/savemenu")
	public ModelAndView save(@ModelAttribute Menu menu) {
		ModelAndView andView=new ModelAndView();
		dao.saveMenu(menu);
		List<Menu> list=dao.getAllMenu();
		andView.addObject("list", list);
		andView.setViewName("displaymenu.jsp");
		return andView;
	}
	@RequestMapping("/menupage")
	public ModelAndView toMenuPage() {
		ModelAndView andView=new ModelAndView();
		List<Menu> list=dao.getAllMenu();
		andView.addObject("list", list);
		andView.setViewName("displaymenu.jsp");
		return andView;
	}
	@RequestMapping("/showmenu")
	public ModelAndView showMenu(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		List<FoodProduct> list=foodProductDao.getAllFoodProducts();
		List<FoodProduct> list2=new ArrayList<FoodProduct>();
		for(FoodProduct foodProduct:list)
		{
			if(foodProduct.getMenu().getId()==id)
				list2.add(foodProduct);
		}
		
//		Menu menu=dao.getMenuById(id);
//		List<FoodProduct> list=menu.getList();
		andView.addObject("list", list2);
		andView.setViewName("menufoodproducts.jsp");
		return andView;
	}
	@RequestMapping("/deletemenu")
	public ModelAndView deleteMenu(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		dao.deleteMenu(id);
		andView.setViewName("menupage");
		return andView;
	}
	@RequestMapping("/updatemenu")
	public ModelAndView updateMenu(@RequestParam int id) {
		ModelAndView andView=new ModelAndView();
		Menu menu=dao.getMenuById(id);
		andView.addObject("menu", menu);
		andView.setViewName("updateMenuDetails.jsp");
		return andView;
	}
	@RequestMapping("/updateMenuDetails")
	public ModelAndView updateDetails(@ModelAttribute Menu menu) {
		ModelAndView andView=new ModelAndView();
		int id=menu.getId();
		Menu menu2=dao.getMenuById(id);
		List<FoodProduct> foodProducts=menu2.getList();
		menu.setList(foodProducts);
		dao.updateMenu(menu);
		andView.setViewName("menupage");
		return andView;
	}
	
	
	

	
}

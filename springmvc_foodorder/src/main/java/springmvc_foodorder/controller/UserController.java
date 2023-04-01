package springmvc_foodorder.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
import springmvc_foodorder.dao.BranchDao;
import springmvc_foodorder.dao.UserDao;
import springmvc_foodorder.dto.Branch;
import springmvc_foodorder.dto.User;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BranchDao branchDao;

	@RequestMapping("/signup")
	public ModelAndView saveUser() {
		ModelAndView andView = new ModelAndView();
		andView.addObject("user", new User());
		andView.setViewName("signup.jsp");
		return andView;
	}

	@RequestMapping("/saveuser")
	public ModelAndView save(@ModelAttribute User user) {
		ModelAndView andView = new ModelAndView();
		userDao.saveUser(user);
		andView.setViewName("home.jsp");
		return andView;

	}

	@RequestMapping("/login")
	public ModelAndView loginform() {
		ModelAndView andView = new ModelAndView();
		andView.addObject("user", new User());
		andView.setViewName("login.jsp");
		return andView;
	}

	@RequestMapping("/loginuser")
	public ModelAndView login(@ModelAttribute User user) {
		User user2 = userDao.getUserByEmail(user.getEmail());

		ModelAndView andView = new ModelAndView();
		if ((user.getEmail().equals(user2.getEmail())) && (user.getPassword().equals(user2.getPassword()))) {

			if (user2.getRole().equals("Manager")) {

				andView.setViewName("menupage");

			} else if (user2.getRole().equals("Staff")) {

				andView.setViewName("displaystaff.jsp");

			} else {
				andView.setViewName("displaybranch");

			}
			return andView;
		} else {

			andView.setViewName("home.jsp");
			return andView;
		}

	}

	@RequestMapping("/assignstaff")
	public ModelAndView assignstaff() {
		ModelAndView andView = new ModelAndView();
		andView.addObject("user", new User());
		andView.setViewName("assignstaff.jsp");
		return andView;
	}

	@RequestMapping("/managers")
	public ModelAndView show() {
		ModelAndView andView = new ModelAndView();
		List<User> list = userDao.showManagers("Manager");
		andView.addObject("list", list);
		andView.setViewName("showmanager.jsp");
		return andView;
	}

	@RequestMapping("/addmanager")
	public ModelAndView addManager(@RequestParam int id) {

		ModelAndView andView = new ModelAndView();
		Branch branch = branchDao.getById(id);
		andView.addObject("branch", branch);
		andView.setViewName("assignmanager.jsp");
		return andView;
	}

	@RequestMapping("/manager")
	public ModelAndView savemanger(@ModelAttribute Branch branch) {
		ModelAndView andView = new ModelAndView();
		// User user = userDao.getUserByEmail( branch.getUser().getEmail());
//		if ((user.getRole().equals("Manager"))) {
//			 branch.setUser(user);
//		        branchDao.updateBranch(branch);
//				//andView.addObject("branch",branch);
//				andView.setViewName("displaybranch");
//		} else {
//			
//			andView.setViewName("displaybranch");
//			
//		}

		User user = userDao.saveUser(branch.getUser());
		branch.setUser(user);
		branchDao.updateBranch(branch);
		andView.setViewName("displaybranch");
		return andView;

	}

	@RequestMapping("/deletemanager")
	public ModelAndView delete(@RequestParam int id) {
		ModelAndView andView = new ModelAndView();
		userDao.deleteUser(id);
		andView.setViewName("managers");
		return andView;
	}

	@RequestMapping("/updatemanager")
	public ModelAndView updateUserDetails(@RequestParam int id) {
		ModelAndView andView = new ModelAndView();
		User user = userDao.getUserByID(id);
		andView.addObject("user", user);
		andView.setViewName("updateuserdetails.jsp");
		return andView;
	}

	@RequestMapping("/userdetails")
	public ModelAndView updateDetails(@ModelAttribute User user) {
		ModelAndView andVie = new ModelAndView();
		userDao.updateUser(user);

		andVie.setViewName("managers");
		return andVie;

	}

}

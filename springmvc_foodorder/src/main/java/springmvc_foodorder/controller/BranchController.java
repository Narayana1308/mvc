package springmvc_foodorder.controller;

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
public class BranchController {
	@Autowired
	private BranchDao dao;
	@Autowired
	private UserDao userDao;

	@RequestMapping("/branch")
	public ModelAndView signup() {
		ModelAndView andView = new ModelAndView();
		andView.addObject("branch", new Branch());
		andView.setViewName("savebranch.jsp");
		return andView;
	}

	@RequestMapping("/savebranch")
	public ModelAndView saveBranch(@ModelAttribute Branch branch) {
		ModelAndView andView = new ModelAndView();
		dao.saveBranch(branch);
		andView.setViewName("displaybranch");
		return andView;
	}

	@RequestMapping("/displaybranch")
	public ModelAndView branch() {
		ModelAndView andView = new ModelAndView();
		List<Branch> list = dao.getAllBranchs();
		andView.addObject("list", list);
		andView.setViewName("displaybranch.jsp");
		return andView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam int id) {
		ModelAndView andView = new ModelAndView();
		dao.deleteBranch(id);
		List<Branch> list = dao.getAllBranchs();
		andView.addObject("list", list);
		andView.setViewName("displaybranch.jsp");
		return andView;
	}

	@RequestMapping("/update")
	public ModelAndView updateBranchDetails(@RequestParam int id) {
		ModelAndView andView = new ModelAndView();
		Branch branch = dao.getById(id);
		andView.addObject("branch", branch);
		andView.setViewName("updatebranchdetails.jsp");
		return andView;
	}

	@RequestMapping("/updatedetails")
	public ModelAndView updatedetails(@ModelAttribute Branch branch) {
		ModelAndView andView = new ModelAndView();
		
		branch.setUser(userDao.getUserByEmail(branch.getUser().getEmail()));
		dao.updateBranch(branch);
		andView.setViewName("displaybranch");
		return andView;

	}

}

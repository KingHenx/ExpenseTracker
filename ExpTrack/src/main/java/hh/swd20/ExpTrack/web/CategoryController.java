package hh.swd20.ExpTrack.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.ExpTrack.domain.Category;
import hh.swd20.ExpTrack.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository cRepository;
	
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) cRepository.findAll();
	}
	
	@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> findPurchaseRest(@PathVariable("id") Long categoryId) {
		return cRepository.findById(categoryId);
	}
	
	@RequestMapping("/categorylist")
	public String index(Model model) {
		
		model.addAttribute("categories", cRepository.findAll());
		
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(Category category) {
		cRepository.save(category);
		return "redirect:main";
	}
	
	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
		cRepository.deleteById(categoryId);
		return "redirect:../categorylist";
	}
	
}


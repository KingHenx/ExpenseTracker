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

import hh.swd20.ExpTrack.domain.CategoryRepository;
import hh.swd20.ExpTrack.domain.Purchase;
import hh.swd20.ExpTrack.domain.PurchaseRepository;

@Controller
public class PurchaseController {

	@Autowired
	private PurchaseRepository pRepository;
	
	@Autowired
	private CategoryRepository cRepository;
	
	@RequestMapping(value="/purchases", method = RequestMethod.GET)
	public @ResponseBody List<Purchase> purchaseListRest() {
		return (List<Purchase>) pRepository.findAll();
	}
	
	@RequestMapping(value="/purchases/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Purchase> findPurchaseRest(@PathVariable("id") Long purchaseId) {
		return pRepository.findById(purchaseId);
	}
	
	@RequestMapping("/*")
	public String index(Model model) {
		
		model.addAttribute("purchases", pRepository.findAll());
		
		return "main";
	}
	
}

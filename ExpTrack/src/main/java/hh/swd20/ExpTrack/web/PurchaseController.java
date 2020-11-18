package hh.swd20.ExpTrack.web;

import java.util.ArrayList;
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
	
	
	@RequestMapping({"/", "/main"})
	public String index(Model model) {
		
		model.addAttribute("purchases", pRepository.findAll());
		model.addAttribute("categories", cRepository.findAll());
		
		for(int month = 1; month < 13; month++) {
			
			double total = 0;
			for(Purchase purchase : pRepository.findAll()) {
				if(purchase.date.getMonthValue() == month)
				total += purchase.price;
			}
			model.addAttribute("data" + month, total);
		}
		
		return "main";
	}
	
	@RequestMapping(value = "/purchasebycategory/{id}")
	public String purchasebycategory(@PathVariable("id") Long categoryid, Model model) {
		
		List<Purchase> purchases = new ArrayList<Purchase>();
		for(Purchase purchase : pRepository.findAll())
			if(purchase.getCategory().getId() == categoryid)
				purchases.add(purchase);
		
		model.addAttribute("purchases", purchases);
		model.addAttribute("categories", cRepository.findAll());
		
		for(int month = 1; month < 13; month++) {
			
			double total = 0;
			for(Purchase purchase : purchases) {
				if(purchase.date.getMonthValue() == month)
				total += purchase.price;
			}
			model.addAttribute("data" + month, total);
			String categoryname = cRepository.findById(categoryid).get().getName();
			model.addAttribute("categoryname", categoryname);
		}
		
		
		return "purchasesbycategory";
	}
	
	
	@RequestMapping(value = "/add")
	public String addPurchase(Model model) {
		model.addAttribute("purchase", new Purchase());
		model.addAttribute("categories", cRepository.findAll());
		return "addpurchase";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Purchase purchase) {
		
		pRepository.save(purchase);
		return "redirect:main";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deletePurchase(@PathVariable("id") Long purchaseId, Model model) {
		pRepository.deleteById(purchaseId);
		return "redirect:../main";
	}
	
	

}

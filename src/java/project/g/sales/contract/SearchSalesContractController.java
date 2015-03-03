package project.g.sales.contract;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import project.g.sales.contract.model.SalesContract;
import project.g.sales.contract.model.SalesContractService;

@RequestMapping(value = "/searchSalesContract")
@Controller
public class SearchSalesContractController {

	@Autowired
	private SalesContractService salesContractService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView begin(@ModelAttribute("salesContract") SalesContract salesContract, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("contract/searchSalesContract");
		Iterable<SalesContract> salesContractIter = salesContractService.findAll();
		for (SalesContract contract : salesContractIter) {
			contract.setDaysRemaining(getDaysRemaining(contract.getDateFrom(), contract.getDateTo()));
		}
		modelView.addObject("results", salesContractIter);
		return modelView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView execute(@ModelAttribute("salesContract") SalesContract salesContract, HttpServletRequest req) {
		ModelAndView modelView = new ModelAndView("contract/searchSalesContract");
		return modelView;
	}
	
	private String getDaysRemaining(Date dateFrom, Date dateTo){
		long diff = dateTo.getTime() - dateFrom.getTime();
		return String.valueOf(diff / 1000 / 60 / 60 / 24);
	}
}

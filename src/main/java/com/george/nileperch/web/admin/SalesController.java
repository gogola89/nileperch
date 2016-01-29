package com.george.nileperch.web.admin;

import com.george.nileperch.domain.nileperch.Sales;
import com.george.nileperch.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by george on 1/24/16.
 */
@Controller
@RequestMapping(value = "/admin/nileperch")
public class SalesController {

    @Autowired
    SalesService salesService;

    @RequestMapping(value = "/sale",method = RequestMethod.GET)
    public String addsale(Model model){
        model.addAttribute("sale",new Sales());
        model.addAttribute("action","CREATE");
        return "/admin/nileperch/salesForm";
    }
    @RequestMapping(value = "/sale/{id}/edit",method = RequestMethod.GET)
    public String editSale(@PathVariable("id") Long id,Model model){
        Sales sales = salesService.getSale(id);
        model.addAttribute("sale",sales);
        model.addAttribute("action","EDIT");
        return "/admin/nileperch/salesForm";
    }

    @RequestMapping(value = "/sale/{action}",method = RequestMethod.POST)
    public String newSale(@ModelAttribute @Valid Sales sales,@PathVariable("action") String action,
                          Model model,BindingResult bindingResult){
        String path = "Failed";
        if(action.equals("CREATE")){
            Sales addSale = salesService.addNewSale(sales);
            return "redirect:/admin/nileperch/sales";
        }
        if(action.equals("EDIT")){
            Sales editedSale = salesService.editSale(sales);
            return "redirect:/admin/nileperch/sale"+sales.getId();
        }
        return path;
    }

    @RequestMapping(value = "/sales",method = RequestMethod.GET)
    public String getSales(Model model){
        List<Sales> allSales = salesService.findAllSales();
        model.addAttribute("sales",allSales);
        return "/admin/nileperch/salesList";
    }

    @RequestMapping(value = "/sale/{id}",method = RequestMethod.GET)
    public String getOneSale(@PathVariable("id") Long id,Model model){
        Sales sales = salesService.getSale(id);
        model.addAttribute("sale",sales);
        return "/admin/nileperch/sale";
    }

    @RequestMapping(value = "/sale/{id}/delete",method = RequestMethod.GET)
    public String deleteOneSale(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        boolean message = salesService.deleteSale(id);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/admin/nileperch/sales";
    }

}

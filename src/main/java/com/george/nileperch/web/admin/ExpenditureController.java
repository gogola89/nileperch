package com.george.nileperch.web.admin;

import com.george.nileperch.domain.nileperch.Expenditure;
import com.george.nileperch.service.ExpenditureService;
import com.george.nileperch.web.front.support.ExpenditureValidator;
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
import javax.xml.ws.Service;
import java.util.List;

/**
 * Created by george on 1/21/16.
 */
@Controller
@RequestMapping(value = "/admin/nileperch")
public class ExpenditureController {
    @Autowired
    ExpenditureService expenditureService;

    @Autowired
    ExpenditureValidator expenditureValidator;

    @RequestMapping(value = "/expenditure",method = RequestMethod.GET)
    public String addExpenditure(Model model){
        model.addAttribute("expenditure",new Expenditure());
        model.addAttribute("action","CREATE");
        return "/admin/nileperch/expenditureForm";
    }

    @RequestMapping(value = "/expenditure/{id}/edit",method = RequestMethod.GET)
    public String editExpenditure(@PathVariable("id") Long id,Model model){
        Expenditure expenditure = expenditureService.getExpenditure(id);
        model.addAttribute("expenditure",expenditure);
        model.addAttribute("action","EDIT");
        return "/admin/nileperch/expenditureForm";
    }

    @RequestMapping(value = "/expenditure/{action}",method = RequestMethod.POST)
    public String newExpenditure(@ModelAttribute @Valid Expenditure expenditure,Model model,
                                 @PathVariable("action") String action, BindingResult bindingResult ){
        String path = "Failed";
        if(action.equals("CREATE")){
            expenditureValidator.validateNewExpenditure(expenditure,bindingResult);
            if(bindingResult.hasErrors()){
                model.addAttribute("expenditure",expenditure);
                return "/admin/nileperch/expenditureForm";
            }
            Expenditure newExpenditure = expenditureService.addNewExpenditure(expenditure);
            return "redirect:/admin/nileperch/expenditures";
        }
        if(action.equals("EDIT")){
            Expenditure editExpense = expenditureService.editExpenditure(expenditure);
            return "redirect:/admin/nileperch/expenditure"+expenditure.getId();
        }
        return path;
    }

    @RequestMapping(value = "/expenditure/{id}",method = RequestMethod.GET)
    public String getExpenditure(@PathVariable("id") Long id,Model model){
        Expenditure expenditure = expenditureService.getExpenditure(id);
        model.addAttribute("expenditure",expenditure);
        return "/admin/nileperch/expenditure";
    }

    @RequestMapping(value = "/expenditures",method = RequestMethod.GET)
    public String getAllExpenses(Model model){
        List<Expenditure> expenditures = expenditureService.getAllExpenditures();
        model.addAttribute("expenditures",expenditures);
        return "/admin/nileperch/expenditureList";
    }

    @RequestMapping(value = "/expenditure/{id}/delete",method = RequestMethod.GET)
    public String deleteExpense(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        boolean message = expenditureService.delete(id);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/admin/nileperch/expenditures";
    }

}

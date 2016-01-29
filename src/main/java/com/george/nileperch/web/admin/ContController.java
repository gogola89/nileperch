package com.george.nileperch.web.admin;

import com.george.nileperch.domain.nileperch.Contribution;
import com.george.nileperch.service.ContService;
import com.george.nileperch.web.front.support.ContValidator;
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
 * Created by george on 1/22/16.
 */
@Controller
@RequestMapping(value = "/admin/nileperch")
public class ContController {
    @Autowired
    ContService contService;

    @Autowired
    ContValidator contValidator;

    @RequestMapping(value = "/contribution",method = RequestMethod.GET)
    public String addCont(Model model){
        model.addAttribute("contribution",new Contribution());
        model.addAttribute("action","CREATE");
        return "/admin/nileperch/contForm";
    }

    @RequestMapping(value = "/contribution/{id}/edit",method = RequestMethod.GET)
    public String editCont(@PathVariable("id") Long id,Model model){
        Contribution contribution = contService.getOneCont(id);
        model.addAttribute("contribution",contribution);
        model.addAttribute("action","EDIT");

        return "/admin/nileperch/contForm";
    }

    @RequestMapping(value = "/contribution/{action}",method = RequestMethod.POST)
    public String saveCont(@ModelAttribute @Valid Contribution contribution,@PathVariable("action") String action,
                           BindingResult bindingResult,Model model){
        String path = "Failed";
        if(action.equals("CREATE")){
            contValidator.validateCont(contribution,bindingResult);
            if(bindingResult.hasErrors()){
                return "/admin/nileperch/contForm";
            }
            Contribution newCont = contService.addNewCont(contribution);
            return "redirect:/admin/nileperch/contributions";
        }
        if(action.equals("EDIT")){
            Contribution editedCont = contService.editCont(contribution);
            return "redirect:/admin/nileperch/contribution"+contribution.getId();
        }
        return path;
    }

    @RequestMapping(value = "/contributions",method = RequestMethod.GET)
    public String allConts(Model model){
        List<Contribution> contributions = contService.findAllConts();
        model.addAttribute("contributions",contributions);
        return "/admin/nileperch/contributionList";
    }

    @RequestMapping(value = "/contribution/{id}",method = RequestMethod.GET)
    public String oneCont(@PathVariable("id") Long id,Model model){
        Contribution contribution = contService.getOneCont(id);
        model.addAttribute("contribution",contribution);
        return "/admin/nileperch/contribution";
    }

    @RequestMapping(value = "/contribution/{id}/delete",method = RequestMethod.GET)
    public String deleteCont(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        boolean message = contService.delete(id);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/admin/nileperch/contributions";
    }
}

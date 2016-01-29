package com.george.nileperch.web.admin;

import com.george.nileperch.domain.nileperch.Members;
import com.george.nileperch.service.MembersService;
import com.george.nileperch.web.front.support.MembersValidator;
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
 * Created by george on 1/18/16.
 */
@Controller
@RequestMapping(value = "/admin/nileperch")
public class MembersController {

    @Autowired
    MembersService membersService;

    @Autowired
    MembersValidator membersValidator;

    @RequestMapping(value = "/membersForm", method = RequestMethod.GET)
    public String registrationForm(Model model){
        model.addAttribute("member",new Members());
        model.addAttribute("action", "CREATE");
        return "/admin/nileperch/membersForm";
    }

    @RequestMapping(value = "/member/{id}/edit",method = RequestMethod.POST)
    public String editMember(@PathVariable("id") Long id,Model model){
        Members members = membersService.getOneMember(id);
        model.addAttribute("member",members);
        model.addAttribute("action","EDIT");
        return "/admin/nileperch/membersForm";
    }

    @RequestMapping(value = "/member/{action}", method = RequestMethod.POST)
    public String newMember(@ModelAttribute @Valid Members members,BindingResult bindingResult,
                            @PathVariable("action") String action, Model model){
        String path = "failed";
        if(action.equals("CREATE")){
            membersValidator.validateNewMember(members,bindingResult);
            if(bindingResult.hasErrors()){
                model.addAttribute("member",members);
                return "/admin/nileperch/membersForm";

            }
            Members newMember = membersService.addNewMember(members);
            return "redirect:/admin/nileperch/members";
        }

        if(action.equals("EDIT")){
            Members editedMember = membersService.editMember(members);
            return "redirect:/admin/nileperch/member"+members.getId();
        }
        return path;
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
    public String getOneMember(@PathVariable("id") Long id,Model model ){
        Members members = membersService.getOneMember(id);
        model.addAttribute("member", members);
        return "/admin/nileperch/member";
    }


    @RequestMapping(value = "/member/{id}/delete", method = RequestMethod.GET)
    public String deleteMember(@PathVariable("id") Long id,RedirectAttributes redirectAttributes){
        boolean message = membersService.delete(id);
        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/admin/nileperch/members";
    }

    @RequestMapping(value = "/members",method = RequestMethod.GET)
    public String showMembers(Model model){
        List<Members> members = membersService.findAllMembers();
        model.addAttribute("members",members);
        return "/admin/nileperch/membersList";

    }


}

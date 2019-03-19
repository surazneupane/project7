package com.example.project7.signupAndlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


@Controller
public class SignupController {
    @Autowired
    SignupRepo signupRepo;


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String displayForm(SignupData signupData) {
        return "signup/signupform";


    }


    @RequestMapping(value="/signup",method = RequestMethod.POST)
    public String postForm(SignupData signupData,ModelMap modelMap) {
        if (signupRepo.findByUsername(signupData.getUsername()) != null) {
            modelMap.addAttribute("message","User Name Is Already Taken");
            return "signup/signupform";

        }

        else if(signupRepo.findByEmail(signupData.getEmail())!=null)
        {
            modelMap.addAttribute("message","Email is Already Taken");
            return "signup/signupform";

        }

        else {
            signupRepo.save(signupData);
           modelMap.addAttribute("sucessmessage","User Registered Sucessfully Please Login To Continue");
            return "signup/signupform";

        }
    }



}

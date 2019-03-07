package com.example.project7.signupAndlogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @Autowired
    SignupRepo signupRepo;
@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String openLoginForm(LoginData loginData)
{

    return "login/loginform";

}

@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String postLoginForm(LoginData loginData, ModelMap modelMap)
{

if(signupRepo.findByUsernameAndUserpassword(loginData.getUsername(),loginData.getUserpassword())!=null)
{

    return "userpage/dashboard";

}

else {


    modelMap.addAttribute("message","UserName Or Password Is Incorrect");
    return "/login/loginform";
}

}
}

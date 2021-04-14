package com.springboot.demo.controllers;


import com.springboot.demo.model.Authorization;
import com.springboot.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloITVDNController {
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping(value = "/authorize-me")
    public ModelAndView authorize(ModelAndView modelAndView) {
        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        authorization.setAuthorized(Boolean.TRUE);
        modelAndView.setViewName("authorized.jsp");
        modelAndView.addObject("authorized", authorization);
        return modelAndView;
    }

    @GetMapping(value = "/unauthorize-me")
    public ModelAndView unAuthorize(ModelAndView modelAndView) {
        Authorization authorization = applicationContext.getBean("userAuthorized", Authorization.class);
        authorization.setAuthorized(Boolean.FALSE);
        modelAndView.setViewName("index.html");
        modelAndView.addObject("authorized", authorization);
        return modelAndView;
    }


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloITVDN() {
        return "index.html";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String listAllEmployee() {
        return "index.html";
    }


    @GetMapping(value = "/bye2")
    public ModelAndView bye(ModelAndView modelAndView) {
        modelAndView.setViewName("bye.jsp");
        return modelAndView;
    }

    @GetMapping(value = "/bye")
    public String bye() {
        return "bye.jsp";
    }


    @GetMapping(value = "/pass-data")
    public String passDataFromUser() {
        return "/pass-data.html";
    }

    @PostMapping(value = "/pass-data")
    public ModelAndView passDataFromUser(@ModelAttribute("user") User user, ModelAndView modelAndView) {
        System.out.println(user);
        modelAndView.setViewName("/summary.html");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(value = "/path/{userName}")
    public ModelAndView greeting(@PathVariable String userName, ModelAndView modelAndView) {
        modelAndView.setViewName("forward:/greeting.jsp");
        modelAndView.addObject("userName", userName);
        return modelAndView;
    }

    @GetMapping(value = "/rest/{name}")
    @ResponseBody
    public String retRest(@PathVariable String name) {
        return name + Math.random() * 1000;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.szaki.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Dani
 */
@Controller
public class LoginController {

    
    /*@RequestMapping(value = "/welcome**", method = RequestMethod.GET)
    public ModelAndView defaultPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Kezdőoldal cím");
        modelAndView.addObject("message", "kezdőoldal üzenet");
        modelAndView.setViewName("hello");
        return modelAndView;
    }*/

    @RequestMapping(value = "/profile**", method = RequestMethod.GET)
    public ModelAndView profilePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("title", "Profile cím");
        modelAndView.addObject("message", "Profile üzenet");
        modelAndView.setViewName("profile");
        return modelAndView;
    }

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout){
        ModelAndView modelAndView = new ModelAndView();

        if (error != null) {
            modelAndView.addObject("error", "Rossz email vagy jelszó!");
        }
        if (logout != null) {
            modelAndView.addObject("msg", "Sikeresen kijelentkezet");
        }

        modelAndView.setViewName("index");
        return modelAndView;
    }
}

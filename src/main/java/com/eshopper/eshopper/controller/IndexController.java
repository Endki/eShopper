package com.eshopper.eshopper.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {


    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(){
        return "checkout";
    }

    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }
    @GetMapping("/blog-single")
    public String blogSingle(){
        return "blog-single";
    }
    @GetMapping("/contact-us")
    public String contactUs(){
        return "contact-us";
    }
    @GetMapping("/product-details")
    public String productDetails(){
        return "product-details";
    }
}

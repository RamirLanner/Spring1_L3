package ru.pentragon.spring.mvc.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.pentragon.spring.mvc.model.Product;
import ru.pentragon.spring.mvc.services.ProductService;

@Controller
//@RequestMapping("/product")
public class ProductController {
    public ProductService productService;

    public ProductController( ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProduct", productService.getAllRecords());
        return "all_products";
    }

    @GetMapping("/product/{id}")
    public String getProductByID(Model model, @PathVariable Long id) {
        model.addAttribute("frontProduct", productService.getByID(id));
        return "product_info";
    }

    @PostMapping("/add")
//    public String addNewBox(@RequestParam Long id, @RequestParam String color, @RequestParam int size) {
    public String addNewBox(@ModelAttribute Product product) {
        productService.add(product);
        return "redirect:/all";
    }

    @PostMapping("/json/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewJsonBox(@RequestBody Product product) {
        productService.add(product);
    }

    @GetMapping("/remove/{id}")
    public String deleteBoxById(@PathVariable Long id) {
        productService.deleteRecordByID(id);
        return "redirect:/all";
    }

}

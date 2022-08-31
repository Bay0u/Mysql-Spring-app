package com.in28minutes.jpa.hibernate.demo5.Controller;

import com.in28minutes.jpa.hibernate.demo5.entity.Products;
import com.in28minutes.jpa.hibernate.demo5.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo ProductR;

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return ProductR.findAll();
    }
    @RequestMapping("/products/{id}")
    public Products getProductById(@PathVariable int id){
        Optional<Products> ob = ProductR.findById(id);
        return ob.orElse(new Products());
    }
    @RequestMapping(method= RequestMethod.POST,value="/products")
    public void addProduct (@RequestBody Products new_product){
        ProductR.save(new_product);
    }

    @RequestMapping(method= RequestMethod.PUT,value="/products/{id}")
    public void updateProduct (@RequestBody Products updated_product , @PathVariable int id){
        ProductR.save(updated_product);
    }
    @RequestMapping(method= RequestMethod.DELETE,value="/products/{id}")
    public void deleteProduct(@PathVariable int id){
        ProductR.deleteById(id);
    }


}

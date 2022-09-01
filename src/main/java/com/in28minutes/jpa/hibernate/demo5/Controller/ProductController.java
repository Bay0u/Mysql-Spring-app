package com.in28minutes.jpa.hibernate.demo5.Controller;

import com.in28minutes.jpa.hibernate.demo5.entity.OrderDetails;
import com.in28minutes.jpa.hibernate.demo5.entity.Orders;
import com.in28minutes.jpa.hibernate.demo5.entity.Products;
import com.in28minutes.jpa.hibernate.demo5.repository.OrderDetailsRepositery;
import com.in28minutes.jpa.hibernate.demo5.repository.OrdersRepositery;
import com.in28minutes.jpa.hibernate.demo5.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepo ProductR;

    @Autowired
    private OrdersRepositery ordersRepositery;

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

        Products ourproduct = getProductById(id);
        int price = ourproduct.getPrice();
        ProductR.save(updated_product);
        List<Orders> orders = new ArrayList<>();
        ordersRepositery.findAll().forEach(orders::add);
        orders.stream()
                .filter(p -> p.isCheckout() )
                .forEach(p -> (p.getDetailsList())
                        .stream().filter( list -> list.getProduct_id() == id).forEach(detail-> detail.setPrice(price)));

    }
    @RequestMapping(method= RequestMethod.DELETE,value="/products/{id}")
    public void deleteProduct(@PathVariable int id){
        ProductR.deleteById(id);
    }


}

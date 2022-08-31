package com.in28minutes.jpa.hibernate.demo5.Controller;

import com.in28minutes.jpa.hibernate.demo5.entity.Customer;
import com.in28minutes.jpa.hibernate.demo5.entity.OrderDetails;
import com.in28minutes.jpa.hibernate.demo5.entity.Orders;
import com.in28minutes.jpa.hibernate.demo5.entity.Products;
import com.in28minutes.jpa.hibernate.demo5.repository.CustomerRepositery;
import com.in28minutes.jpa.hibernate.demo5.repository.OrderDetailsRepositery;
import com.in28minutes.jpa.hibernate.demo5.repository.OrdersRepositery;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrdersRepositery ordersRepositery;
    @Autowired
    private OrderDetailsRepositery orderDetailsRepositery;
    @Autowired
    private ProductController productController;

    @RequestMapping("/orders")
    public List<Orders> getAllOrders(){
        List<Orders> orders = new ArrayList<>();
        ordersRepositery.findAll().forEach(orders::add);
        return orders;
    }

    @RequestMapping("/ordersDetails")
    public List<OrderDetails> getAllOrdersDetails(){
        List<OrderDetails> orders = new ArrayList<>();
        orderDetailsRepositery.findAll().forEach(orders::add);
        return orders;
    }

    @RequestMapping("/orders/{id}")
    public Optional<Orders> getOrderById(@PathVariable int id){
        return ordersRepositery.findById(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="/orders")
    public void addOrder (@RequestBody Orders new_order){
        ordersRepositery.save(new_order);
    }

//    @RequestMapping("/orders/{id}")
//    public List<OrderDetails> getOrderDetailsByOrderId(@PathVariable int id){
//        List<OrderDetails> orders = new ArrayList<>();
//        orderDetailsRepositery.findAll().forEach(orders::add);
//        return orders;
//    }
    @RequestMapping(method= RequestMethod.POST,value="/makeOrder/{id}")
    public void addOrder (@RequestBody Orders order , @PathVariable int id){

        Products products = productController.getProductById(id);

        int Product_Id = products.getId();

        OrderDetails orderDetails = new OrderDetails();

        orderDetails.setOrder_id(order.getId());
        orderDetails.setProduct_id(Product_Id);
        orderDetails.setPrice(products.getPrice());

        order.setTotal_price(order.getTotal_price()+products.getPrice());

        addOrder(order);

        orderDetailsRepositery.save(orderDetails);
    }

    @RequestMapping(method= RequestMethod.PUT,value="/Checkout/{id}")
    public void CheckOut (@PathVariable int id){

        Orders order = getOrderById(id).orElse(new Orders());
        order.setCheckout(true);
        ordersRepositery.save(order);

    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.spring_demo.Model.Controller;

import org.springframework.ui.Model; // Import yang benar untuk Model
import com.example.spring_demo.Model.Order;
import com.example.spring_demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/list")
    public String listOrders(Model model) {
        // Menambahkan daftar order ke model untuk ditampilkan di view
        model.addAttribute("orders", orderService.getAllOrders());
        return "order-list"; // View: order-list.html
    }

    @GetMapping("/add")
    public String addOrderForm(Model model) {
        // Menambahkan objek order kosong untuk form
        model.addAttribute("order", new Order());
        return "order-add"; // View: order-add.html
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute("order") Order order) {
        // Menyimpan order baru
        orderService.saveOrder(order);
        return "redirect:/order/list"; // Redirect ke daftar order
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        // Menghapus order berdasarkan ID
        orderService.deleteOrder(id);
        return "redirect:/order/list"; // Redirect ke daftar order
    }
}

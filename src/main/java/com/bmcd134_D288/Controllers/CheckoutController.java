package com.bmcd134_D288.Controllers;

import com.bmcd134_D288.Services.CheckoutService;
import com.bmcd134_D288.Services.Purchase;
import com.bmcd134_D288.Services.PurchaseResponse;
import jakarta.validation.Valid;
import jdk.jfr.Percentage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/api/checkout/purchase")
    public PurchaseResponse placeOrder(@RequestBody @Valid Purchase purchase) {

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

        return purchaseResponse;
    }
}

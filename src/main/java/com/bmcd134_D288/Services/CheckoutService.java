package com.bmcd134_D288.Services;

import com.bmcd134_D288.Services.Purchase;
import com.bmcd134_D288.Services.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}

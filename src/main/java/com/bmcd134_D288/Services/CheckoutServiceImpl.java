package com.bmcd134_D288.Services;

import com.bmcd134_D288.Entities.Cart;
import com.bmcd134_D288.Entities.CartItem;
import com.bmcd134_D288.Entities.StatusType;
import com.bmcd134_D288.dao.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        if (purchase == null || purchase.getCartItems() == null || purchase.getCartItems().isEmpty()) {
            throw new IllegalArgumentException("Purchase cannot be null");
        }

        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);

        StatusType status = StatusType.ordered;
        cart.setStatus(status);


        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}

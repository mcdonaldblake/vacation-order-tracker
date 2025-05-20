package com.bmcd134_D288.Services;

import com.bmcd134_D288.Entities.Cart;
import com.bmcd134_D288.Entities.CartItem;
import com.bmcd134_D288.Entities.Customer;
import com.bmcd134_D288.Entities.StatusType;
import com.bmcd134_D288.dao.CartRepository;
import com.bmcd134_D288.dao.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        if (purchase.getCart() == null ||
                purchase.getCartItems() == null ||
                purchase.getCartItems().isEmpty()) {
            return new PurchaseResponse("ERROR: your cart cannot be empty");
        }

        Customer customer = purchase.getCustomer();
        customerRepository.save(customer);

        Cart cart = new Cart();
        cart.setPackage_price(purchase.getCart().getPackage_price());
        cart.setParty_size(purchase.getCart().getParty_size());
        cart.setStatus(StatusType.ordered);

        cart.setCustomer(customer);

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(cart::add);


        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber() {

        return UUID.randomUUID().toString();
    }
}

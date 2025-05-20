package com.bmcd134_D288.Services;

import com.bmcd134_D288.Entities.Cart;
import com.bmcd134_D288.Entities.CartItem;
import com.bmcd134_D288.Entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;

@Data
@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}

package com.bmcd134_D288.Services;

import com.bmcd134_D288.Entities.Cart;
import com.bmcd134_D288.Entities.CartItem;
import com.bmcd134_D288.Entities.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.Set;
import java.util.HashSet;

@Data
@Getter
@Setter
public class Purchase {

    @Valid
    @NotNull(message = "Customer info is required")
    private Customer customer;

    @Valid
    @NotNull(message = "Cart must be provided")
    private Cart cart;

    @Valid
    @NotEmpty(message = "You must order at least one item")
    private Set<CartItem> cartItems;
}

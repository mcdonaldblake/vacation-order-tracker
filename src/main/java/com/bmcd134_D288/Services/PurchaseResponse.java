package com.bmcd134_D288.Services;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@Getter
@Setter
public class PurchaseResponse {
    @NonNull
    private String orderTrackingNumber;
}

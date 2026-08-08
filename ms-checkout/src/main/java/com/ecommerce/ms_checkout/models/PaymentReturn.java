package com.ecommerce.ms_checkout.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentReturn {
    private String status;
    private String motivo;

}

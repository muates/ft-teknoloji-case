package com.muates.ftteknolojicase.product.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ProductCreateRequest {

    @NotBlank
    private String productName;

    @NotNull
    private Integer price;

    private Date expirationDate;

}

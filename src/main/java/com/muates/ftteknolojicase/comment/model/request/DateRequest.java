package com.muates.ftteknolojicase.comment.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class DateRequest {

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

}

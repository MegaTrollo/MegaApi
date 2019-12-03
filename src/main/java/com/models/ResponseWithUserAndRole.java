package com.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseWithUserAndRole{
    private String jwtToken;
    private int roleId;
    private Long accountId;

}

package com.technical_test.technical_test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataUserDTO {
    private Integer userId;
    private String namaLengkap;
    private String username;
    private String password;
    private Character status;
}

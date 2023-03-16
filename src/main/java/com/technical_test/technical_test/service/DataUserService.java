package com.technical_test.technical_test.service;

import com.technical_test.technical_test.dto.DataUserDTO;
import com.technical_test.technical_test.model.DataUser;

import java.util.List;

public interface DataUserService {
    List<DataUser> findAll();
    DataUser findByUserId(Integer userId);
    DataUser create(DataUser dataUser);
    Boolean delete(Integer userId);
    DataUserDTO mapToDto(DataUser dataUser);
    DataUser mapToEntity(DataUserDTO dataUserDTO);
}

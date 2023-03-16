package com.technical_test.technical_test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.technical_test.technical_test.dto.DataUserDTO;
import com.technical_test.technical_test.model.DataUser;
import com.technical_test.technical_test.repository.DataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DataUserServiceImpl implements DataUserService{

    @Autowired
    DataUserRepository dataUserRepository;

    @Override
    public List<DataUser> findAll() {
        return dataUserRepository.findAll();
    }

    @Override
    public DataUser findByUserId(Integer userId) {
        return dataUserRepository.findByUserId(userId);
    }

    @Override
    public DataUser create(DataUser dataUser) {
        final DataUser result = dataUserRepository.save(dataUser);
        return result;
    }

    @Override
    public Boolean delete(Integer userId) {
        DataUser result = findByUserId(userId);
        if (result != null) {
            dataUserRepository.deleteById(userId);
            return true;
        }
        return false;
    }


    ObjectMapper mapper = new ObjectMapper();

    @Override
    public DataUserDTO mapToDto(DataUser dataUser) {
        return mapper.convertValue(dataUser, DataUserDTO.class);
    }

    @Override
    public DataUser mapToEntity(DataUserDTO dataUserDTO) {
        return mapper.convertValue(dataUserDTO, DataUser.class);
    }
}

package com.technical_test.technical_test.service;

import com.technical_test.technical_test.dto.DataUserDTO;
import com.technical_test.technical_test.repository.DataUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;


@Service
@Transactional
public class DataUserService {

    private final String HMDM_USER_API_URL = "http://localhost:8080/api/users";
    private final RestTemplate restTemplate = new RestTemplate();


    @Autowired
    DataUserRepository dataUserRepository;

    public List<DataUserDTO> findAll() {
        DataUserDTO[] users = restTemplate.getForObject(HMDM_USER_API_URL, DataUserDTO[].class);
        return Arrays.asList(users);
    }

    public DataUserDTO findByUserId(Integer userId) {
        String url = HMDM_USER_API_URL + "/" + userId;
        return restTemplate.getForObject(url, DataUserDTO.class);
    }

    public DataUserDTO create(DataUserDTO dataUserDTO) {
        return restTemplate.postForObject(HMDM_USER_API_URL, dataUserDTO, DataUserDTO.class);
    }


    public DataUserDTO update(Integer userId, DataUserDTO dataUserDTO) {
        String url = HMDM_USER_API_URL + "/" + userId;
        restTemplate.put(url, dataUserDTO);
        return dataUserDTO;
    }


    public Boolean delete(Integer userId) {
        String url = HMDM_USER_API_URL + "/" + userId;
        restTemplate.delete(url);
        return true;
    }

}

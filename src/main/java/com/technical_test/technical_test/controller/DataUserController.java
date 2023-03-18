package com.technical_test.technical_test.controller;

import com.technical_test.technical_test.dto.DataUserDTO;
import com.technical_test.technical_test.model.DataUser;
import com.technical_test.technical_test.service.DataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data_user")
public class DataUserController {

    @Autowired
    DataUserService dataUserService;

    @PostMapping("/create")
    public DataUserDTO create(@RequestBody DataUserDTO request) {
        final DataUser dataUser = dataUserService.mapToEntity(request);
        final DataUser result = dataUserService.create(dataUser);
        return dataUserService.mapToDto(result);

    }

    @GetMapping("/all")
    public List<DataUserDTO> findAll(){
        return dataUserService.findAll().stream().map(dataUser -> dataUserService.mapToDto(dataUser)).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{userId}")
    public Boolean delete(@PathVariable Integer userId){
        return dataUserService.delete(userId);
    }
}

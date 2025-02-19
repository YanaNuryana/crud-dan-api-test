package com.technical_test.technical_test.controller;

import com.technical_test.technical_test.dto.DataUserDTO;
import com.technical_test.technical_test.service.DataUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data_user")
public class DataUserController {

    @Autowired
    DataUserService dataUserService;

    @PostMapping("/create")
    public DataUserDTO create(@RequestBody DataUserDTO request) {
        return dataUserService.create(request);
    }

    @GetMapping("/all")
    public List<DataUserDTO> findAll() {
        return dataUserService.findAll();
    }

    @PutMapping("/{userId}")
    public DataUserDTO updateUser(@PathVariable Integer userId, @RequestBody DataUserDTO dataUserDTO) {
        return dataUserService.update(userId, dataUserDTO);
    }

    @DeleteMapping("/delete/{userId}")
    public Boolean delete(@PathVariable Integer userId) {
        return dataUserService.delete(userId);
    }
}

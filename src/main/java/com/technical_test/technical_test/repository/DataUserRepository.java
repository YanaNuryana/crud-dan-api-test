package com.technical_test.technical_test.repository;

import com.technical_test.technical_test.model.DataUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataUserRepository extends JpaRepository<DataUser, Integer> {
    DataUser findByUserId(Integer userId);
}

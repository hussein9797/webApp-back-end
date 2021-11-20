package com.example.demo.Repository;


import com.example.demo.Model.Parameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Parameter;

@Repository
public interface ParametersRepository extends JpaRepository<Parameters,Long> {

    Parameters findByKey(String key);
}
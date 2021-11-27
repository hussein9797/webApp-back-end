package com.example.demo.Service;

import com.example.demo.Model.Parameters;
import com.example.demo.Repository.ParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Parameter;
@Service
public class ParametersServiceImpl implements ParametersService {
    @Autowired
    ParametersRepository parametersRepository;
    @Override
    @Cacheable("parameters")
    public double getValueByKey(String key) {
        try
        {
        Parameters parameter= parametersRepository.findByKey(key);
        return parameter.getValue();
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}

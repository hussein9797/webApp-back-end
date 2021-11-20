package com.example.demo.Service;

import com.example.demo.Model.Estates;
import com.example.demo.dto.request.EstatesFilterObject;
import com.example.demo.dto.request.EstatesRequest;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EstatesService {
    void AddEstates(EstatesRequest estatesRequest,Long userId);
    void deleteEstates(Long EstatesId) throws NotFoundException;
    List<Estates> getAllEstates();
    void updateEstates(EstatesRequest estatesRequest) throws NotFoundException;
    List<Estates> filterEstates(EstatesFilterObject estatesFilterObject) ;

}

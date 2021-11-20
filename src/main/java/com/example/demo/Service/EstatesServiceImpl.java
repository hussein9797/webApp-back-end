package com.example.demo.Service;

import com.example.demo.Model.Estates;
import com.example.demo.Model.User;
import com.example.demo.Repository.EstatesRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.request.EstatesFilterObject;
import com.example.demo.dto.request.EstatesRequest;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.Service.UserDetailsServiceImpl.userId;

@Service
public class EstatesServiceImpl implements EstatesService {
    @Autowired
    EstatesRepository estatesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ParametersServiceImpl parametersServiceImpl;

    @Override
    public void AddEstates(EstatesRequest estatesRequest, Long userId) {
        User user = userRepository.getOne(userId);
        Estates estates = new Estates();
        double defaultSellingPrice=(estatesRequest.getStock_price())*(parametersServiceImpl.getValueByKey("default_percentage_profit"));
        estates.setName(estatesRequest.getName());
        if (estatesRequest.getStock_count() == null) {
            estates.setStockCount(parametersServiceImpl.getValueByKey("default_stock_count"));

        } else {
            estates.setStockCount(estatesRequest.getStock_count());
        }

        estates.setStockPrice(estatesRequest.getStock_price());

        estates.setSellDate(estatesRequest.getSell_date());

        estates.setSellingPrice(defaultSellingPrice);
        estates.setInvestorName(estatesRequest.getInvestor_name());
        estates.setUser(user);

        estatesRepository.save(estates);

    }

    @Override
    public void deleteEstates(Long EstatesId) throws NotFoundException {

        estatesRepository.deleteById(EstatesId);


    }

    public List<Estates> getAllEstates() {
        try {

            return estatesRepository.findAllByUserId(userId);
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void updateEstates(EstatesRequest estatesRequest) throws NotFoundException {
        try {
            Estates estates = estatesRepository.getById(estatesRequest.getId());
            estates.setName(estatesRequest.getName());
            estates.setStockPrice(estatesRequest.getStock_price());
            estates.setStockCount(estatesRequest.getStock_count());
            estates.setSellDate(estatesRequest.getSell_date());
            estates.setSellingPrice(estatesRequest.getSelling_price());
            estates.setInvestorName(estatesRequest.getInvestor_name());
            estatesRepository.save(estates);


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public List<Estates> filterEstates(EstatesFilterObject estatesFilterObject)  {
        try {

            List<Estates> result;
            if (!estatesFilterObject.getEstate_name().isEmpty() || !estatesFilterObject.getEstate_name().isBlank())
                result = estatesRepository.findAllByName(estatesFilterObject.getEstate_name());
            else if (  estatesFilterObject.getPrice() != null  )
                result = estatesRepository.findAllByStockPriceLessThanEqual(estatesFilterObject.getPrice());
            else if (  estatesFilterObject.getStock_count() != null)
                result = estatesRepository.findAllByStockCountLessThanEqual(estatesFilterObject.getStock_count());
            else
                result = estatesRepository.findAll();

            return result;
        } catch (Exception e) {
               e.getMessage();
            return null;

        }

    }
}

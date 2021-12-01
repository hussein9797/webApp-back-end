package com.example.demo.Service;

import com.example.demo.Excptions.AnotherProcessOfBuyingIsInUse;
import com.example.demo.Model.Estates;
import com.example.demo.Model.Sales;
import com.example.demo.Model.User;
import com.example.demo.Repository.EstatesRepository;
import com.example.demo.Repository.SalesRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.ScenariosManagement.BuyingUtil;
import com.example.demo.dto.request.EstatesFilterObject;
import com.example.demo.dto.request.EstatesIdsRequst;
import com.example.demo.dto.request.EstatesRequest;
import com.example.demo.enums.SaleType;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.example.demo.Service.UserDetailsServiceImpl.userId;

@Service
public class EstatesServiceImpl implements EstatesService {
    private static final Logger logger = LoggerFactory.getLogger(EstatesServiceImpl.class);
    @Autowired
    EstatesRepository estatesRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    ParametersServiceImpl parametersServiceImpl;

    @Override
    public void AddEstates(EstatesRequest estatesRequest, Long userId) {
        User user = userRepository.getOne(userId);
        Estates estates = new Estates();

        logger.info("User  " + user.getUsername() + "  adding new EState");


        double defaultSellingPrice = (estatesRequest.getStock_price()) * (parametersServiceImpl.getValueByKey("default_percentage_profit"));
        estates.setName(estatesRequest.getName());
        if (estatesRequest.getStock_count() == null) {
            estates.setStockCount(parametersServiceImpl.getValueByKey("default_stock_count"));

        } else {
            estates.setStockCount(estatesRequest.getStock_count());
        }

        estates.setStockPrice(estatesRequest.getStock_price());

        estates.setSellDate(estatesRequest.getSell_date());
        estates.setSaleType(SaleType.ON_SALE);

        estates.setSellingPrice(defaultSellingPrice);
        estates.setInvestorName(estatesRequest.getInvestor_name());
        estates.setUser(user);
        estates.setCreatedAt(new Date());
        estates.setUpdatedAt(new Date());
        estates.setCreatedBy(user.getUsername());
        estates.setUpdatedBy(user.getUsername());

        estatesRepository.save(estates);

    }

    @Override
    public void deleteEstates(Long EstatesId) throws NotFoundException {
        User user = userRepository.getOne(userId);


        estatesRepository.deleteById(EstatesId);
        logger.info("User  " + user.getUsername() + "  deleted a Estates");


    }

    public List<Estates> getAllEstates() {
        try {
            User user = userRepository.getOne(userId);
            logger.info("User  " + user.getUsername() + "  Shows its Estates");

            return estatesRepository.findAllByUserId(userId);

        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void updateEstates(EstatesRequest estatesRequest) throws NotFoundException {
        try {
            User user = userRepository.getOne(userId);
            Estates estates = estatesRepository.getById(estatesRequest.getId());
            estates.setName(estatesRequest.getName());
            logger.info("User  " + user.getUsername() + "  updated  Estates  " + estates.getName() + "information");

            estates.setStockPrice(estatesRequest.getStock_price());
            estates.setStockCount(estatesRequest.getStock_count());
            estates.setSellDate(estatesRequest.getSell_date());
            estates.setSellingPrice(estatesRequest.getSelling_price());
            estates.setInvestorName(estatesRequest.getInvestor_name());
            estates.setUpdatedAt(new Date());
            estates.setUpdatedBy(user.getUsername());
            estatesRepository.save(estates);


        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public List<Estates> filterEstates(EstatesFilterObject estatesFilterObject) {
        try {

            List<Estates> result;
            if (!estatesFilterObject.getEstate_name().isEmpty() || !estatesFilterObject.getEstate_name().isBlank())
                result = estatesRepository.findAllByName(estatesFilterObject.getEstate_name());
            else if (estatesFilterObject.getPrice() != null)
                result = estatesRepository.findAllByStockPriceLessThanEqual(estatesFilterObject.getPrice());
            else if (estatesFilterObject.getStock_count() != null)
                result = estatesRepository.findAllByStockCountLessThanEqual(estatesFilterObject.getStock_count());
            else
                result = estatesRepository.findAll();

            return result;
        } catch (Exception e) {
            e.getMessage();
            return null;

        }

    }

    @Override
    @Transactional(readOnly = false)
    public void BuyEstates(EstatesIdsRequst estatesIdsRequst) throws NotFoundException {

        try {

            User user = userRepository.getOne(userId);
            List<Long> EstatesIds = estatesIdsRequst.getEstates_ids();



                List<Estates> EstatesToBuy = estatesRepository.findAllById(EstatesIds);

                if (EstatesToBuy.isEmpty())
                    throw new NotFoundException("not found some estates are missing ");

            for (Estates estate : EstatesToBuy) {
                Sales sale = new Sales();

                sale.setEstates(estate);
                sale.setUser(user);
                sale.setSellDate(new Date());
                try {
                    BuyingUtil.ValidateBuyingProcess(estate.getSaleType());

                } catch (Exception e) {
                    throw e;
                }
                estate.setSaleType(SaleType.PENDING);
                estatesRepository.save(estate);


                salesRepository.save(sale);

            }
        } catch (Exception e) {
            throw e;
        }

    }
}

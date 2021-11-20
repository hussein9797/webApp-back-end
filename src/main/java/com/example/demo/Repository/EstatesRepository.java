package com.example.demo.Repository;

import com.example.demo.Model.Estates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstatesRepository extends JpaRepository<Estates,Long> {

    List<Estates> findAllByUserId( long userId);
    List<Estates> findAllByName(String name);
    List<Estates> findAllByStockCountLessThanEqual(double stockCount);
    List<Estates> findAllByStockPriceLessThanEqual(double stockPrice);

}

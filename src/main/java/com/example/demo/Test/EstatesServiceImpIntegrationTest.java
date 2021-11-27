package com.example.demo.Test;

import com.example.demo.Model.Estates;
import com.example.demo.Model.User;
import com.example.demo.Repository.EstatesRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.EstatesService;
import com.example.demo.Service.EstatesServiceImpl;
import com.example.demo.Service.UserDetailsServiceImpl;
import com.example.demo.enums.SaleType;
import javassist.NotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EstatesServiceImpIntegrationTest {


    @Mock
    EstatesService estatesService;

    private MockMvc mockMvc;

    @Mock
    EstatesRepository estatesRepository;
    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() {
       Estates estates = new Estates();
       User user = userRepository.getOne((long) 1);
        estates.setName("mazzeh");
estates.setId((long) 1);
        estates.setStockPrice(123.23);

        estates.setSellDate(new Date());
        estates.setSaleType(SaleType.ON_SALE);

        estates.setSellingPrice(1654);
        estates.setInvestorName("Ahmad");
        estates.setUser(user);
        Mockito.when( estatesRepository.findByName(estates.getName()))
                .thenReturn(estates);

    }

    @Test
    public void whenValidName_thenEstateShouldBeFound() {
        String name = "mazzeh";
        Estates found = estatesRepository.findByName(name);
//
//        assertThat(found.getName())
//                .isEqualTo(name);

    }
//    @Test
//    public void deleteEstate() throws Exception {
//
//        Mockito.when( estatesService.deleteEstates((long) 1))
//                .thenReturn("success");
//        mockMvc.perform(MockMvcRequestBuilders.delete("/applications", 1))
//                .andExpect(status().isOk());
//    }
//
@Test
public void TestDeleteEstates() throws Exception {
    Long EstatesId=1L;

    estatesService.deleteEstates(EstatesId);

   Mockito.verify(estatesService, times(1)).deleteEstates( eq(EstatesId));

          // mockMvc.perform(MockMvcRequestBuilders.delete("/admin/Estates/deleteEstates", 1)).andExpect(status().isOk());
    }

//    @Test
//    public void whenValidNameAfterUpdate_thenEstateShouldBeFound() {
//        String name = "Dummar";
//
//        Estates estates=  estatesRepository.getById(1L);
//        estates.setName(name);
//        estatesRepository.save(estates);
//        Estates found = estatesRepository.findByName(name);
//
//        assertThat(found.getName())
//                .isEqualTo(name);
//
//    }






}

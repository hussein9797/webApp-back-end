package com.example.demo.Controller;

import com.example.demo.Service.EstatesService;
import com.example.demo.Service.UserDetailsServiceImpl;
import com.example.demo.dto.request.EstatesRequest;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/Estates")
public class EstatesAdministrationController {
    @Autowired
    EstatesService estatesService;

    @PostMapping(value = "/addEstates")
    @PreAuthorize("hasAuthority('estates_write')")
    public ResponseEntity<Object> addEstates(@RequestBody EstatesRequest estatesRequest) throws Exception {
        try {
            estatesService.AddEstates(estatesRequest, UserDetailsServiceImpl.userId);


        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>("massage :\"Error Bad Request\"", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("massage :\"Estates Add Successfully\"", HttpStatus.OK);

    }

    @DeleteMapping(value = "/deleteEstates/{Estates_id}")
    @PreAuthorize("hasAuthority('estates_write')")
    public ResponseEntity<Object> deleteEstates(@PathVariable("Estates_id") Long EstatesId) throws Exception {
        try {
            estatesService.deleteEstates(EstatesId);
        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("massage :\"Estates deleted Successfully\"", HttpStatus.OK);

    }

    @PutMapping(value = "/updateEstates")
    @PreAuthorize("hasAuthority('estates_write')")
    public ResponseEntity<Object> updateEstates(@RequestBody EstatesRequest estatesRequest) throws NotFoundException {
        try {
            estatesService.updateEstates(estatesRequest);


        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("massage :\"Estates updated Successfully\"", HttpStatus.OK);

    }


}



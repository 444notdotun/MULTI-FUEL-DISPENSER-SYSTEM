package org.multidispenser.multifueldispenser.controller;

import org.multidispenser.multifueldispenser.dtos.request.AddFuelRequest;
import org.multidispenser.multifueldispenser.dtos.request.SellFuelRequest;
import org.multidispenser.multifueldispenser.dtos.response.AddFuelResponse;
import org.multidispenser.multifueldispenser.dtos.response.SellFuelResponse;
import org.multidispenser.multifueldispenser.services.AttendantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendant")
public class AttendantController {
    @Autowired
    private AttendantService attendantService;

    @PostMapping("/addFuel")
    public ResponseEntity<?> addFuel(@RequestBody AddFuelRequest request){

        AddFuelResponse addFuelResponse = attendantService.addFuel(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(addFuelResponse);
    }

    @PostMapping("sellFuel")
        public ResponseEntity<?> sellFuel(@RequestBody SellFuelRequest request){
        SellFuelResponse response = attendantService.sellFuel(request);
        return  ResponseEntity.status(HttpStatus.CREATED).body(response);
        }




}

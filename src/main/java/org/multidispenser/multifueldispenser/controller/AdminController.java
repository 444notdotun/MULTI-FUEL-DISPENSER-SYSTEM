package org.multidispenser.multifueldispenser.controller;

import org.multidispenser.multifueldispenser.dtos.request.CreateAttendantRequest;
import org.multidispenser.multifueldispenser.dtos.response.CreateAttendantResponse;
import org.multidispenser.multifueldispenser.services.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//base URl
@RequestMapping("admin/")
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    // to enter request
  @PostMapping("createAttendant")
  public ResponseEntity<?> createAttendant(@RequestBody CreateAttendantRequest request){
      CreateAttendantResponse response = adminServices.createAttendant(request);
      return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

}

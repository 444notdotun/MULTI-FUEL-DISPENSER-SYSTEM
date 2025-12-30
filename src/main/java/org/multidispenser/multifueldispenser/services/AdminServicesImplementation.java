package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.data.models.Attendant;
import org.multidispenser.multifueldispenser.data.repository.AttendantRepository;
import org.multidispenser.multifueldispenser.dtos.request.CreateAttendantRequest;
import org.multidispenser.multifueldispenser.dtos.response.CreateAttendantResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class AdminServicesImplementation implements  AdminServices{

    private final AttendantRepository attendantRepository;
    public AdminServicesImplementation(AttendantRepository attendantRepository){
        this.attendantRepository = attendantRepository;
    }
    @Override
    public CreateAttendantResponse createAttendant(CreateAttendantRequest request) {
        Attendant attendant = new Attendant(request.getName(),true);
        CreateAttendantResponse response = new CreateAttendantResponse();
        response.setMessage("welcome! registration successful!");
        attendantRepository.save(attendant);
        return response;
    }
}

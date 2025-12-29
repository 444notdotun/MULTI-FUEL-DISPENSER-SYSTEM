package org.multidispenser.multifueldispenser.services;

import org.multidispenser.multifueldispenser.dtos.request.CreateAttendantRequest;
import org.multidispenser.multifueldispenser.dtos.response.CreateAttendantResponse;
import org.springframework.stereotype.Service;

@Service
public interface AdminServices {
 CreateAttendantResponse createAttendant(CreateAttendantRequest request);
}

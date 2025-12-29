package org.multidispenser.multifueldispenser.data.repository;

import org.multidispenser.multifueldispenser.data.models.Attendant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendantRepository extends MongoRepository<Attendant, String> {
    Attendant findAttendantsByName(String name);
}

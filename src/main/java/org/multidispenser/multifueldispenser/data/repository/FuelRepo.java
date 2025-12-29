package org.multidispenser.multifueldispenser.data.repository;

import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuelRepo extends MongoRepository<Fuel, String> {
    Fuel findByNameIgnoreCase(String name);

}

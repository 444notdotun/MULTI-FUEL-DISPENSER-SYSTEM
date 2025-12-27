package org.multidispenser.multifueldispenser.data.repository;

import com.mongodb.client.MongoDatabase;
import org.multidispenser.multifueldispenser.data.models.Fuel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelRepository extends MongoRepository<String, Fuel> {
}

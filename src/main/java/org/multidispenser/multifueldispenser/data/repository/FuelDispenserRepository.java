package org.multidispenser.multifueldispenser.data.repository;

import com.mongodb.client.MongoDatabase;
import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuelDispenserRepository  extends MongoRepository<String, FuelDispenser> {
}

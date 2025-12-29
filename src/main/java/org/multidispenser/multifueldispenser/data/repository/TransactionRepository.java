package org.multidispenser.multifueldispenser.data.repository;

import org.multidispenser.multifueldispenser.data.models.FuelDispenser;
import org.multidispenser.multifueldispenser.data.models.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends MongoRepository<Transactions, String> {
}

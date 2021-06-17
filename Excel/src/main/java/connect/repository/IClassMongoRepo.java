package connect.repository;

import connect.entities.EduClass;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.math.BigInteger;

public interface IClassMongoRepo extends MongoRepository<EduClass, BigInteger> {

}

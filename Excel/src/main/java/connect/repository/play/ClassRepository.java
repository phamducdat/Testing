package connect.repository.play;

import connect.entities.Class;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends MongoRepository<Class, String> {
}

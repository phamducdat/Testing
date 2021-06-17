package connect.repository;

import connect.entities.EduCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICourseMongoRepo extends MongoRepository<EduCourse, String> {
}

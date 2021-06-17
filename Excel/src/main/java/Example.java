import java.util.List;

import connect.entities.EduClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.util.Pair;

public class Example {
    @Autowired
    MongoTemplate mongoTemplate;
    public void bulkInsertEduClass(List<EduClass> updates){
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.ORDERED,"class");
        bulkOperations.insert(updates);
        System.out.println("OKKKKKKKKKKKKKKKK");
    }
}
package connect.repository.play;

import java.util.List;

import connect.entities.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String>{

    @Query("{ 'name': ?0}")
    List<Player> findByName(String name);

    List<Player> findByNameLike(String name);
}

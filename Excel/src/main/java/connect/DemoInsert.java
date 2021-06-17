package connect;

import connect.entities.Player;
import connect.repository.play.PlayerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoInsert {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoInsert.class, args);
        PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
        System.out.println("--------------- Insert -----------------");
        Player player1 = new Player();
        player1.setName("Ronaldo");
        player1.setAge(33);
        player1.setFootballClub("Juventus");
        player1.setPosition("Striker");
        playerRepository.save(player1);

        Player player2 = new Player();
        player2.setId("1");
        player2.setName("Ramos");
        player2.setAge(19);
        player2.setFootballClub("Real Madrid");
        player2.setPosition("Midfielder");
        playerRepository.save(player2);

        Player player3 = new Player();
        player3.setId("1");
        player3.setName("Ramos");
        player3.setAge(19);
        player3.setFootballClub("Real Madrid");
        player3.setPosition("Midfielder");
        playerRepository.save(player3);
        System.out.println("Insert Success!");

        System.out.println("--------------- FindAll -----------------");
        List<Player> allPlayers = playerRepository.findAll();
        for(Player player: allPlayers) {
            System.out.println(player);
        }

    }
}

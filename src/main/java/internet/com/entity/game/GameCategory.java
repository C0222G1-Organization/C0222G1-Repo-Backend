package internet.com.entity.game;

import javax.persistence.*;

@Entity(name = "game_category")
public class GameCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}

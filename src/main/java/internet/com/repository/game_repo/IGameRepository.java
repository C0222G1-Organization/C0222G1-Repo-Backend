package internet.com.repository.game_repo;

import internet.com.entity.game.Game;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IGameRepository extends PagingAndSortingRepository<Game, Integer> {

}

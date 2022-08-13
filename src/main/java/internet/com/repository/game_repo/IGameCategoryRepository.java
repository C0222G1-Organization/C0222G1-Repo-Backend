package internet.com.repository.game_repo;

import internet.com.entity.game.GameCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IGameCategoryRepository extends PagingAndSortingRepository<GameCategory, Integer> {
}

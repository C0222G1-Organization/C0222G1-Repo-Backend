package internet.com.repository.game_repo;

import internet.com.entity.game.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface IGameRepository extends PagingAndSortingRepository<Game, Integer> {
    /*
     * Created by: KienNDT,
     * Date created: 09/08/2022
     * Function: to get all games
     */
    @Query(value = "select id, game_name, game_category_id, create_date, played_times, " +
            "trailer_url, image_url, content from game", nativeQuery = true)
    Page<Game> getAll(Pageable pageable);

    /*
     * Created by: KhanhTV,
     * Date created: 09/08/2022
     * Function: to get all popular games
     */
    @Query(value = "select id, game_name, game_category_id, create_date, played_times, " +
            "trailer_url, image_url, content from game WHERE game_category_id = 1", nativeQuery = true)
    Page<Game> getPopularGames(Pageable pageable);

    /*
     * Created by: KhanhTV,
     * Date created: 09/08/2022
     * Function: to get all new games
     */
    @Query(value = "select id, game_name, game_category_id, create_date, played_times, " +
            "trailer_url, image_url, content from game WHERE game_category_id = 2", nativeQuery = true)
    Page<Game> getNewGames(Pageable pageable);

    /*
     * Created by: KhanhTV,
     * Date created: 09/08/2022
     * Function: to get all hot games
     */
    @Query(value = "select id, game_name, game_category_id, create_date, played_times, " +
            "trailer_url, image_url, content from game WHERE game_category_id = 3", nativeQuery = true)
    Page<Game> getHotGames(Pageable pageable);

    /*
     * Created by: KienNTD,
     * Date created: 09/08/2022
     * Function: to save game
     */
    @Modifying
    @Query(value = "insert into game(game_name, game_category_id, create_date, played_times, trailer_url, image_url, content) " +
            "values(:game_name, :game_category_id, :create_date, :played_times, :trailer_url, :image_url, :content) ", nativeQuery = true)
    void saveGame(@Param("game_name") String name,
                  @Param("game_category_id") Integer gameCategoryId,
                  @Param("create_date") String createDate,
                  @Param("played_times") Integer playedTimes,
                  @Param("trailer_url") String trailerUrl,
                  @Param("image_url") String imageUrl,
                  @Param("content") String content);

    /*
     * Created by: KienNTD,
     * Date created: 09/08/2022
     * Function: to update game by id
     */
    @Modifying
    @Query(value = "update game set game_name =:game_name, game_category_id =:game_category_id, create_date =:create_date, " +
            "played_times =:played_times, trailer_url =:trailer_url, image_url =:image_url, content =:content where id =:id", nativeQuery = true)
    void updateGame(@Param("game_name") String name,
                    @Param("game_category_id") Integer gameCategoryId,
                    @Param("create_date") String createDate,
                    @Param("played_times") Integer playedTimes,
                    @Param("trailer_url") String trailerUrl,
                    @Param("image_url") String imageUrl,
                    @Param("content") String content,
                    @Param("id") Integer id);

    /*
     * Created by: KhanhTV,
     * Date created: 09/08/2022
     * Function: to delete game
     */
    @Modifying
    @Query(value = "DELETE FROM game WHERE id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);

    /*
     * Created by: KhanhTV,
     * Date created: 09/08/2022
     * Function: to find game by id
     */
    @Query(value = "SELECT id, game_name, game_category_id, " +
            "create_date, played_times, trailer_url, image_url, content FROM game WHERE id = :id", nativeQuery = true)
    Game findGameById(@Param("id") Integer id);

    /*
     * Created by: KhanhTV,
     * Date created: 09/08/2022
     * Function: to search game by name
     */
    @Query(value = "SELECT id, game_name, game_category_id, " +
            "create_date, played_times, trailer_url, image_url, content FROM game WHERE game_name LIKE :game_name", nativeQuery = true)
    Page<Game> searchByName(@Param("game_name") String name, Pageable pageable);
}

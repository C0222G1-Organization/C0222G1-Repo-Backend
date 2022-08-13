package internet.com.repository.news_repo;

import internet.com.entity.news.News;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
@Transactional
public interface INewsRepository extends JpaRepository<News, Integer> {

}

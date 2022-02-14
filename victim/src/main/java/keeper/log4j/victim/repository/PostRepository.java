package keeper.log4j.victim.repository;

import java.util.Optional;
import keeper.log4j.victim.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

  Optional<PostEntity> findByContentAndRegisterDate(String content, String registerDate);
}

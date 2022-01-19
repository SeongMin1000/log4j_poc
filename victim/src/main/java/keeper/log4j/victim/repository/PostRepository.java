package keeper.log4j.victim.repository;

import keeper.log4j.victim.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}

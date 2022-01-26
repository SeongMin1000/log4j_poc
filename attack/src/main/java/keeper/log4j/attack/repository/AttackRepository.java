package keeper.log4j.attack.repository;

import keeper.log4j.attack.controller.AttackMainController;
import keeper.log4j.attack.entity.AttackEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackRepository extends JpaRepository<AttackEntity, Long> {
}


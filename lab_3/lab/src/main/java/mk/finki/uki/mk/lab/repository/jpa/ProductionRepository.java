package mk.finki.uki.mk.lab.repository.jpa;

import mk.finki.uki.mk.lab.model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionRepository extends JpaRepository<Production, Long> {

}

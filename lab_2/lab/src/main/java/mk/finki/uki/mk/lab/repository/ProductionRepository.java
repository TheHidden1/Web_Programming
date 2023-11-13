package mk.finki.uki.mk.lab.repository;

import mk.finki.uki.mk.lab.bootstrap.DataHolder;
import mk.finki.uki.mk.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductionRepository {

    public List<Production> findAll(){
        return DataHolder.productions;
    }
    public Optional<Production> findById(Long productionId) {
        return DataHolder.productions.stream()
                .filter(i -> i.getId().equals(productionId))
                .findFirst();
    }
}

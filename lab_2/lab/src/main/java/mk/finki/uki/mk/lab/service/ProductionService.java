package mk.finki.uki.mk.lab.service;

import mk.finki.uki.mk.lab.model.Production;

import java.util.List;
import java.util.Optional;

public interface ProductionService {
    public List<Production> findAll();
    Optional<Production> findById(Long id);
}

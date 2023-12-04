package mk.finki.uki.mk.lab.service.impl;

import mk.finki.uki.mk.lab.model.Production;
import mk.finki.uki.mk.lab.repository.impl.InMemoryProductionRepository;
import mk.finki.uki.mk.lab.repository.jpa.ProductionRepository;
import mk.finki.uki.mk.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductionServiceImpl implements ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }


    @Override
    public List<Production> findAll() {
        return this.productionRepository.findAll();
    }

    @Override
    public Optional<Production> findById(Long id) {
        return this.productionRepository.findById(id);
    }
}

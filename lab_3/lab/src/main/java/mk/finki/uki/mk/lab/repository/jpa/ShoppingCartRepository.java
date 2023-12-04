package mk.finki.uki.mk.lab.repository.jpa;

import mk.finki.uki.mk.lab.model.ShoppingCart;
import mk.finki.uki.mk.lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findById(long id);
    Optional<ShoppingCart> findByUser(User user);
    ShoppingCart save(ShoppingCart cart);
}

package org.example.pharmashop.Repository;

import org.example.pharmashop.Model.Pharma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PharmaRepo extends JpaRepository<Pharma, Long> {
    Optional<Pharma> findFirstByName(String name);
    Optional<Pharma> findPharmaByDescription(String description);
    Optional<Pharma> findPharmaByPrice(Integer price);
    Optional<Pharma>findByName(String name);
}

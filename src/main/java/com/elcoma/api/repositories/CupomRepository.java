package com.elcoma.api.repositories;

import com.elcoma.api.domain.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Integer> {
}

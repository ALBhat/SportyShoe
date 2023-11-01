package com.simplilearn.SportyShoes.repository;

import com.simplilearn.SportyShoes.model.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepository extends JpaRepository<Shoe,Long> {
}

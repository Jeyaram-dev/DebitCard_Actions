package com.card.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.card.EntityCard;

@Repository
public interface Repo extends JpaRepository<EntityCard, Integer> {


	

}

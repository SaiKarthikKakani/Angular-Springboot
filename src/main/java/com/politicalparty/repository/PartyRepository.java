package com.politicalparty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.politicalparty.model.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Long>{

}

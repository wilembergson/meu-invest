package com.wilembergson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilembergson.domain.Investimento;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long>{

}

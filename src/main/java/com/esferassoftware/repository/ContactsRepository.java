package com.esferassoftware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esferassoftware.model.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Long>{
	
	@Query("SELECT e FROM Contact e WHERE e.nome = :nome")
	public Optional<Contact> findByName(@Param("nome") String nome);

}

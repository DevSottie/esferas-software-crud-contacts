package com.esferassoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esferassoftware.model.Contact;

public interface ContactsRepository extends JpaRepository<Contact, Long>{

}

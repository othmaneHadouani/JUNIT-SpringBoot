package org.sid.demo.dao;

import org.sid.demo.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepeository extends JpaRepository<Personne,Long> {

}

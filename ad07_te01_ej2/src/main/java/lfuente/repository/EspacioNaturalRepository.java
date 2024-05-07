package lfuente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import lfuente.domain.EspacioNatural;

// repositorio para la clase Espacio Natural
public interface EspacioNaturalRepository extends MongoRepository<EspacioNatural, Integer>{
	
}

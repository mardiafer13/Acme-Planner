package acme.features.administrator.spamWord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.configuration.Configuration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamWordRepository extends AbstractRepository{

	@Query("select c from Configuration c where c.id = ?1")
	Configuration findOneById(int id);

	@Query("select c from Configuration c")
	Collection<Configuration> findManyAll();
	
}

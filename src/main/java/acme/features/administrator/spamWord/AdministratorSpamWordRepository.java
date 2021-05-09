package acme.features.administrator.spamWord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spamWords.SpamWord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamWordRepository extends AbstractRepository{

	@Query("select s from SpamWord s where s.id = ?1")
	SpamWord findOneById(int id);

	@Query("select s from SpamWord s")
	Collection<SpamWord> findManyAll();
	
}

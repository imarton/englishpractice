package org.martoni;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, Long> {

	List<Word> findByHungarian(String hungarianWord);
	
	List<Word> findByEnglish(String englishWord);
	
	List<Word> findAll();

	Iterable<Word> findTop5ByOrderByUsageAsc();
	
}

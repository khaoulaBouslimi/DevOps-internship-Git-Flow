package tn.esprit.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

	Page<Quiz> findByIsPublishedTrue(Pageable pageable);

	@Query("select q from Quiz q where q.name like %?1%")
	Page<Quiz> searchByName(String query, Pageable pageable);

}

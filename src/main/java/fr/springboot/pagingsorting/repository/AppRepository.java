package fr.springboot.pagingsorting.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.springboot.pagingsorting.model.AppModel;

@Repository
public interface AppRepository extends JpaRepository<AppModel,Integer> {
	
	/**
	 * Find all and Paging and/or Sorting
	 */
	Page<AppModel> findAll(Pageable pageable);
}

package com.codingdojo.mvc.repo;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.model.EmModel;


	@Repository
public interface EmRepo extends CrudRepository <EmModel,Long>{
		List<EmModel> findAll();
		Optional<EmModel> findById(Long id);

	}


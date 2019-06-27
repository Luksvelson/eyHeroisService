package br.com.eyHerois.repository;

import java.util.List;
import br.com.eyHerois.model.*;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

public interface EyHeroisRepository extends Repository<EyHeroisModel, Integer> {
	
	void save(EyHeroisModel heroi);
	
	void delete(EyHeroisModel heroi);
	
	List<EyHeroisModel> findAll();
	
	EyHeroisModel findById(Integer id);
}

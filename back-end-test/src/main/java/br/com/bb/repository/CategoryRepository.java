package br.com.bb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}

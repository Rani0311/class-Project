package dev.ankit.productservice.repositories;

import dev.ankit.productservice.models.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.concurrent.Callable;

public interface  CategoryRepository extends JpaRepository<Category,Long> {
    Category findByTitle(String title);
    Category save(Category category);




    Optional<Category> findById(Long id);


}

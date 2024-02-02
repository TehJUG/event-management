package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;

import ir.tehran.jug.projects.eventmanagement.data.entities.Category;
import ir.tehran.jug.projects.eventmanagement.data.repositories.CategoryRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Optional <Category> findByCategoryTitle(String categoryTitle) {
        Optional <Category> category = repository.findByTitle(categoryTitle);
        if (category.isEmpty())
            throw new EntityNotFoundException("Entity not exist");
        return category;
    }
}

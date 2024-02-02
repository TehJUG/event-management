package ir.tehran.jug.projects.eventmanagement.usecase.services.impl;

import ir.tehran.jug.projects.eventmanagement.data.entities.Category;
import ir.tehran.jug.projects.eventmanagement.data.repositories.CategoryRepository;
import ir.tehran.jug.projects.eventmanagement.usecase.services.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryRepository> implements CategoryService {
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }

    @Override
    public Category findByCategoryTitle(String categoryTitle) {
        Category category = repository.findByTitle(categoryTitle);
        if (category == null)
            throw new EntityNotFoundException("Entity not exist");
        return category;
    }
}

package ir.tehran.jug.projects.eventmanagement.usecase.services;

import ir.tehran.jug.projects.eventmanagement.data.entities.Category;

import java.util.Optional;

public interface CategoryService extends BaseService<Category,Long> {
    Optional<Category> findByCategoryTitle(String categoryTitle);
}

package ir.tehran.jug.projects.eventmanagement.usecase.services;

import ir.tehran.jug.projects.eventmanagement.data.entities.Category;

public interface CategoryService extends BaseService<Category,Long> {
    Category findByCategoryTitle(String categoryTitle);
}

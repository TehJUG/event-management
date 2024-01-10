package ir.tehran.jug.projects.eventmanagement.data.repositories;

import ir.tehran.jug.projects.eventmanagement.data.base.repository.BaseRepository;
import ir.tehran.jug.projects.eventmanagement.data.entities.Category;

public interface CategoryRepository extends BaseRepository<Category, Long> {
    Category findByTitle(String categoryTitle);
}

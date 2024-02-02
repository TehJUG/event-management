package ir.tehran.jug.projects.eventmanagement.data.entities;

import ir.tehran.jug.projects.eventmanagement.data.entities.events.Event;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "category")
public class Category extends BaseEntity<Long> {

    @Column(unique = true)
    @NotBlank(message = "title can't be blank")
    private String title;

    @OneToMany(mappedBy = "eventCategory")
    private Set<Event> events;
}

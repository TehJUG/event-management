package ir.tehran.jug.projects.eventmanagement.data.entities;

import ir.tehran.jug.projects.eventmanagement.data.base.entity.BaseEntity;
import ir.tehran.jug.projects.eventmanagement.data.entities.events.Event;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tag")
public class Tag extends BaseEntity<Long> {

    @Column(unique = true)
    @NotBlank(message = "title can't be blank")
    private String title;


    @ManyToMany(mappedBy = "tags")
    private Set<Event> events;
}

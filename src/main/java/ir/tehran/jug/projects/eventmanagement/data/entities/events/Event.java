
package ir.tehran.jug.projects.eventmanagement.data.entities.events;

import ir.tehran.jug.projects.eventmanagement.data.base.entity.BaseEntity;
import ir.tehran.jug.projects.eventmanagement.data.entities.Category;
import ir.tehran.jug.projects.eventmanagement.data.entities.Tag;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "event")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Event extends BaseEntity<Long> {

//       Online  -> /date, /time, /title, /tags, /price, /description, /picture, /capacity, category, timetable,  ----- platform, link
//       Offline -> date, time, title, tags, price, description, picture, capacity, category, timetable,  ----- address, location on map,

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @NotBlank(message = "title can't be blank")
    private String title;

    private String description;

    private int price;

    private byte[] picture;

    private short capacity;

    @ManyToMany
    @JoinTable(
            name = "event_tags",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category eventCategory;

}

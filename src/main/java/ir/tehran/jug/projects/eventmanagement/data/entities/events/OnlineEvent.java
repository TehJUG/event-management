package ir.tehran.jug.projects.eventmanagement.data.entities.events;


import ir.tehran.jug.projects.eventmanagement.data.entities.enums.Platform;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "event")
public class OnlineEvent extends Event {

    //    platform, link

    private Platform platform;
    private String link;


}

package ir.tehran.jug.projects.eventmanagement.data.entities.events;


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
public class OfflineEvent extends Event {

//    address, location on map

    private String address;
    private String locationOnMap;

}

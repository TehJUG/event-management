package ir.tehran.jug.projects.eventmanagement.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
public class Organizer extends BaseEntity<Long> {

    @NotBlank(message = "Name can not be empty!")
    private String name;

    @NotBlank(message = "Phone number can not be empty!")
    @Digits(integer = 11,
            fraction = 0,
            message = "Phone number must contains 12 digits!")
    @Column(name = "phone_number",
            columnDefinition = "varchar(20)",
            unique = true,
            nullable = false)
    private String phoneNumber;

    private String url;

    private String description;

    @ManyToOne
    private User user;
}

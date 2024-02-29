package ir.tehran.jug.projects.eventmanagement.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Table(name = "users")
@Entity
public class User extends BaseEntity<Long> {

    @NotBlank(message = "Name can not be empty!")
    private String name;

    @NotBlank(message = "Phone number can not be empty!")
    @Digits(integer = 11,
            fraction = 0,
            message = "Phone number must contains 11 digits!")
    @Column(name = "phone_number",
            columnDefinition = "varchar(20)",
            unique = true,
            nullable = false)
    private String phoneNumber;

    @Email
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Organizer> organizerList = new HashSet<>();

}

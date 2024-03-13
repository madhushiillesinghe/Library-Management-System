package lk.ijse.library.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@AllArgsConstructor
@NoArgsConstructor
@Data

@Embeddable
public class Name {
    private String firstName;
    private String lastName;

}

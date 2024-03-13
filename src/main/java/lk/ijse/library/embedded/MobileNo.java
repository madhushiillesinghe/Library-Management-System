package lk.ijse.library.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class MobileNo {
    private String mobileNo;
    private String type;

}

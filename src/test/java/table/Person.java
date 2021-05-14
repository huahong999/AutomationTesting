package table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private String email;
    private String website;
    private Float due;
}


package by.tms.l32_35;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    Integer id;
    String name;
    String username;
    String password;
    int codeTelephone;
    int telephone;
}

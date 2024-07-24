package by.tms.l28_29.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String userName;
    private String password;
    private String email;
}
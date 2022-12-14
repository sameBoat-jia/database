package j2ee1.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private Boolean isLogin;
}

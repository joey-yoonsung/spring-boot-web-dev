package jpa.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private Integer age;
    private Date createdAt;

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @PrePersist
    public void beforeCreate(){
        createdAt = new Date();
    }

    public UserEntity(String userName) {
        this.userName = userName;
    }

    public UserEntity(String userName, Integer age, UserRole role) {
        this.userName = userName;
        this.age = age;
        this.role = role;
    }
}

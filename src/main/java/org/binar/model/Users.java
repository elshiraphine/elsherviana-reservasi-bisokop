package org.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 64, unique = true)
    private String user_name;

    @Column(nullable = false, length = 32, unique = true)
    private String user_email;

    @Column(nullable = false, length = 32)
    private String user_password;

    @Column(nullable = false, length = 32)
    private String user_phone;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, insertable = false)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Set<Reserve> reserves;
}

package org.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reserve_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, insertable = false)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserve_ticket")
    private Set<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_users_reserve"))
    private Users users;
}

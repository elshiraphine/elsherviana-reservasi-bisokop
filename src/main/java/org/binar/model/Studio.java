package org.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studio_id;

    @Column(nullable = false, length = 256)
    private String studio_name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, insertable = false)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studio")
    private Set<Showtime> showtimes;
}

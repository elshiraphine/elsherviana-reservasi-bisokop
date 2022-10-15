package org.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedule_id;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private Date endTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, insertable = false)
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private Set<Showtime> show_times;
}

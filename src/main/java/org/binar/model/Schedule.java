package org.binar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import java.util.Timer;

@Entity
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedule_id;

    // @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime startTime;

    // @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime endTime;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "schedule")
    private Set<Showtime> show_times;
}

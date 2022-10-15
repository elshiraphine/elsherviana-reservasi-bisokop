package org.binar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtime_id;

    @Column(nullable = false)
    private Date showtime;

    @Column(nullable = false)
    private double price;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "showtime_ticket")
    private Set<Ticket> tickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", nullable = false, foreignKey = @ForeignKey(name = "fk_showtime_film"))
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id", nullable = false, foreignKey = @ForeignKey(name = "fk_showtime_schedule"))
    private Schedule schedule;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studio_id", nullable = false, foreignKey = @ForeignKey(name = "fk_studio_showtime"))
    private Studio studio;
}

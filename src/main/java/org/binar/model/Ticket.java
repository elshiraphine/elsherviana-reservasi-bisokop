package org.binar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showtime_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ticket_showtime"))
    private Showtime showtime_ticket;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserve_id", nullable = false, foreignKey = @ForeignKey(name = "fk_reserve_ticket"))
    private Reserve reserve_ticket;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "seat_id")
    private Seat seat;
}

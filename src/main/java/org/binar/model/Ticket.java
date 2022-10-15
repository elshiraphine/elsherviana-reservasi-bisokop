package org.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticket_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, insertable = false)
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

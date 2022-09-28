package org.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seat_id;

    @Column(nullable = false)
    private int seat_number;

    @Column(nullable = false, length = 1)
    private String seat_row;

    @Column(nullable = false)
    private boolean seat_status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, insertable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false, insertable = false)
    private Date updatedAt;

    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Ticket ticket;
}

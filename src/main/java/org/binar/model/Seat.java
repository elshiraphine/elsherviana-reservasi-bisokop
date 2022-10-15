package org.binar.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(mappedBy = "seat", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Ticket ticket;
}

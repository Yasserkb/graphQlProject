package org.sid.bankaccountservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.sid.bankaccountservice.enums.AccountType;

import javax.persistence.*;
import java.util.Date;

//@Builder look it up it;s a design pattern very popular
@Entity @Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
//    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;

//    @PrePersist
//    private void prePersist() {
//        // Set the createdAt field to the current date before persisting the entity.
//        this.createdAt = new Date();
//    }
}

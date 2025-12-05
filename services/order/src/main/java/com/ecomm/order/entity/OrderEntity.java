package com.ecomm.order.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String reference;
    private Integer CustomerId;
    private BigDecimal totalAmount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderLine> orderLines;
//    @CreatedDate
//    @Column(updatable = false)
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    @Column(updatable = true,insertable = false)
//    private LocalDateTime lastModifiedAt;


}

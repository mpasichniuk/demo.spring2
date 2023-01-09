package com.example.demo.spring2.subjects;

import com.example.demo.spring2.subjects.UserDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import order_builder.OrderItem;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
    @Table(name = "orders")
    @NoArgsConstructor
    @Data
    public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private UserDTO user;

        @Column(name = "total_price")
        private BigDecimal totalPrice;

        @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        private List<OrderItem> items;

        @Column(name = "created_at")
        @CreationTimestamp
        private LocalDateTime createdAt;

        @Column(name = "updated_at")
        @UpdateTimestamp
        private LocalDateTime updatedAt;
    }



package com.arrelin.inventory.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inventory")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "sku_code")
        private String skuCode;

        @Column(name = "quantity")
        private Integer quantity;
}

// skuCode is mainly(for now or until mvp) BRAND(3)/MODEL(2)/RAM(2-3)/STORAGE(2-3) expamle SAM1232128 refers to Samsung/12/32/128

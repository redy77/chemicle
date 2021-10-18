package com.chemcool.school.constructor.domain.сomparison;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comparison_statement")
public class ComparisonStatement {

    public ComparisonStatement(String value, Integer orderNumber) {
        this.value = value;
        this.orderNumber = orderNumber;
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "uuid", updatable = false, nullable = false)
    private String uuid;

    @Column
    private String value;

    @Column
    private Integer orderNumber;
}

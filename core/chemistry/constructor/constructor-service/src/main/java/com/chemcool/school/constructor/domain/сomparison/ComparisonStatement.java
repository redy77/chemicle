package com.chemcool.school.constructor.domain.сomparison;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comparison_statement")
public class ComparisonStatement {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;

    @Column
    private String value;

    @Column
    private Integer order_number;

    @OneToOne(fetch = FetchType.LAZY)
    private ComparisonPair comparisonPair;
}

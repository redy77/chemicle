package com.chemcool.school.constructor.domain.сomparison;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ComparisonStatement {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;

    @Column
    private String value;

    @Column
    private Integer order;

    @OneToOne(fetch = FetchType.LAZY)
    private ComparisonPair comparisonPair;
}

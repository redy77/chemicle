package com.chemcool.school.constructor.domain.сomparison;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "comparison_pair")
public class ComparisonPair {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String uuid;

    @OneToOne
    private ComparisonStatement key;

    @OneToOne
    private ComparisonStatement value;

    @ManyToOne(fetch = FetchType.LAZY)
    private Comparison comparison;
}

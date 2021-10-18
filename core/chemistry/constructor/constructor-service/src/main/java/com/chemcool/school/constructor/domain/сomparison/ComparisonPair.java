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
    @Column(name = "uuid", updatable = false, nullable = false)
    private String uuid;

    @OneToOne(cascade = CascadeType.ALL)
    private ComparisonStatement key;

    @OneToOne(cascade = CascadeType.ALL)
    private ComparisonStatement value;
}

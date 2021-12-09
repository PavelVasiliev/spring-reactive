package ru.innotech.education.rxjava.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(chain = true)
@Table("subscription")
public class SubscriptionEntity {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String link;
    @Column
    private String title;
    @Column
    private String description;
}

package ru.innotech.education.rxjava.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
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


    public SubscriptionEntity(String link) {
        this.link = link;
        name = "name";
        title = "title";
    }
}

package ru.innotech.education.rxjava.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubscriptionRequest {
    private String link;
}

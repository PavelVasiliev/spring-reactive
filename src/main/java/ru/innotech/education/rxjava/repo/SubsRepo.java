package ru.innotech.education.rxjava.repo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.innotech.education.rxjava.domain.SubscriptionEntity;

@Repository
public interface SubsRepo extends ReactiveCrudRepository<SubscriptionEntity, Integer> {
}

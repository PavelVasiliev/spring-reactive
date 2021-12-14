package ru.innotech.education.rxjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.innotech.education.rxjava.domain.SubscriptionEntity;
import ru.innotech.education.rxjava.repo.SubsRepo;

@Service
public class SubsServ {

    @Autowired
    private SubsRepo subsRepo;

    public Mono<SubscriptionEntity> save(String link){
        System.out.println("saving " + link);
        return subsRepo.save(new SubscriptionEntity(link));
    }
}

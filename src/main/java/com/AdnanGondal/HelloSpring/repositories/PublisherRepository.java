package com.AdnanGondal.HelloSpring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.AdnanGondal.HelloSpring.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {

}

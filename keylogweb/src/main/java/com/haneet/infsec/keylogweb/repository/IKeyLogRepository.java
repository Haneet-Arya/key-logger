package com.haneet.infsec.keylogweb.repository;

import com.haneet.infsec.keylogweb.entity.KeyLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKeyLogRepository extends CrudRepository<KeyLog, Long> {

}

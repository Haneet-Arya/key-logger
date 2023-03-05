package com.haneet.infsec.keylogweb.repository;

import com.haneet.infsec.keylogweb.entity.KeyLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Emre Sen - 14.05.2019
 * @contact maemresen07@gmail.com
 */
@Repository
public interface IKeyLogRepository extends CrudRepository<KeyLog, Long> {

}

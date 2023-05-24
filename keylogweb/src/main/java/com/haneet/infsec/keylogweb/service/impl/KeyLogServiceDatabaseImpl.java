package com.haneet.infsec.keylogweb.service.impl;

import com.haneet.infsec.keylogweb.entity.KeyLog;
import com.haneet.infsec.keylogweb.repository.IKeyLogRepository;
import com.haneet.infsec.keylogweb.service.IKeyLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class KeyLogServiceDatabaseImpl implements IKeyLogService {

    @Autowired
    private IKeyLogRepository keyLogRepository;

    @Override
    public List<KeyLog> getKeyLogList() {
        return StreamSupport.stream(keyLogRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public KeyLog save(KeyLog keyLog) {
        return keyLogRepository.save(keyLog);
    }
}

package com.haneet.infsec.keylogweb.service;

import com.haneet.infsec.keylogweb.entity.KeyLog;

import java.util.List;


public interface IKeyLogService {

    public List<KeyLog> getKeyLogList();

    public KeyLog save(KeyLog keyLog);

}

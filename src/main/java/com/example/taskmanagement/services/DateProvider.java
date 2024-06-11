package com.example.taskmanagement.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class DateProvider {

    public LocalDateTime getCurrentDate() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

}

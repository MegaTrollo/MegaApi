package com.example.demo.services;

import com.example.demo.entity.TableWindow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableWindowService {
    List<TableWindow> getAll();

    TableWindow changeNameById(int id, String name);
}

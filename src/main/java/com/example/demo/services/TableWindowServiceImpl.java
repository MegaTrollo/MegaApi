package com.example.demo.services;

import com.example.demo.entity.TableWindow;
import com.example.demo.repository.TableWindowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableWindowServiceImpl implements TableWindowService {

    private TableWindowRepository tableWindowRepository;

    @Autowired
    public TableWindowServiceImpl(TableWindowRepository tableWindowRepository) {
        this.tableWindowRepository = tableWindowRepository;
    }

    @Override
    public List<TableWindow> getAll() {
        return this.tableWindowRepository.findAll();
    }

    @Override
    public TableWindow changeNameById(int id, String name) {
        return this.tableWindowRepository.updateTableWindowNameById(id, name);
    }
}

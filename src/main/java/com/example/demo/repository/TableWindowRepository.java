package com.example.demo.repository;

import com.example.demo.entity.TableWindow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TableWindowRepository extends JpaRepository<TableWindow, Long> {

    @Query("update TableWindow tw set tw.name = ?2 where tw.id = ?1")
    TableWindow updateTableWindowNameById(int id, String name);
}

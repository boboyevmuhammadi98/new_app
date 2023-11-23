package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task extends AbstractUUIDEntity {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false)
    private Status status;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne
    private Priority priority;

    @ManyToOne
    private Task parentTaskId;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private boolean startTimeHas;

    @Column(nullable = false)
    private LocalDateTime dueDate;

    @Column(nullable = false)
    private boolean dueDateHas;

    @Column(nullable = false)
    private Long estimateTime;

    @Column(nullable = false)
    private LocalDateTime activeDate;
}

package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.DependencyTaskName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskDependency extends AbstractUUIDEntity {

    @ManyToOne(optional = false)
    private Task task;

    @ManyToOne(optional = false)
    private Task dependencyTaskId;

    @Enumerated(EnumType.STRING)
    private DependencyTaskName dependencyTaskName;
}

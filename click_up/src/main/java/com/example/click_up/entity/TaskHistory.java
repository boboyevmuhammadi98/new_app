package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TaskHistory extends AbstractUUIDEntity {

    @ManyToOne(optional = false)
    private Task task;

    @Column(nullable = false)
    private String changedFieldName;

    @Column(nullable = false)
    private Object before;

    @Column(nullable = false)
    private Object after;

    @Column(nullable = false)
    private Object data;

}

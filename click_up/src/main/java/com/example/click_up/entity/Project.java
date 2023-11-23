package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.ObjectAccessType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project extends AbstractUUIDEntity {
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Space space;

    @Enumerated(EnumType.STRING)
    private ObjectAccessType accessType;

    @Column(nullable = false)
    private boolean archived;

    @Column(nullable = false)
    private String color;

}

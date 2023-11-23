package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WorkspaceRole extends AbstractUUIDEntity {
    @Column(nullable = false, unique = true)
    private String name;

    @Column()
    private String description;

    @ManyToOne(optional = true)
    private WorkspaceRole extendsRole;

    @ManyToOne
    private Workspace workspace;
}

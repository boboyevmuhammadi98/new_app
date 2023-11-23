package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.ObjectAccessType;
import com.example.click_up.enums.TaskPermission;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProjectUser extends AbstractUUIDEntity {

    @ManyToOne(optional = false)
    private Project project;

    @ManyToOne(optional = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private TaskPermission permission;

}

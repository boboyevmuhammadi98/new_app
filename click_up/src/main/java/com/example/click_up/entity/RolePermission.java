package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.RolePermissionName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"role_id", "permission"}))
public class RolePermission extends AbstractUUIDEntity {
    @ManyToOne
    private Role role;

    @Enumerated(EnumType.STRING)
    private RolePermissionName permission;
}

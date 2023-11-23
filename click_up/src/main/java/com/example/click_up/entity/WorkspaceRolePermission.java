package com.example.click_up.entity;

import com.example.click_up.entity.template.AbstractUUIDEntity;
import com.example.click_up.enums.WorkspaceRolePermissionName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class WorkspaceRolePermission extends AbstractUUIDEntity {
    @ManyToOne
    private WorkspaceRole workspaceRole;

    @Enumerated(EnumType.STRING)
    private WorkspaceRolePermissionName permission;
}

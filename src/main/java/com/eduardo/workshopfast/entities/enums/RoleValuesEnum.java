package com.eduardo.workshopfast.entities.enums;

public enum RoleValuesEnum {
    ADMINISTRATOR(1L), COLLABORATOR(2L);

    private long roleId;

    RoleValuesEnum(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }
}

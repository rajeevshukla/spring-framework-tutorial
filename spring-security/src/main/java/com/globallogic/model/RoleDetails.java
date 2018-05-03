package com.globallogic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ROLE_DETAILS")
public class RoleDetails implements GrantedAuthority {

	private static final long serialVersionUID = -6907317178208338118L;
	@Id
	@Column(name="ROLE_NAME",length=20)
	private String roleName;
	@Column(name="ROLE_DESC", length=50)
	private String roleDesc;

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}


	public String getAuthority() {
		return roleName;
	}

	@Override
	public String toString() {
		return "RoleDetails [roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}

}

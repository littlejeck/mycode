package com.atguigu.atcrowdfunding.api;

import java.util.List;

import com.atguigu.atcrowdfunding.bean.TMenu;
import com.atguigu.atcrowdfunding.bean.TPermission;

public interface PermissionService {

	List<TPermission> getAllPermissions();

	void savePermission(TPermission permission);

	void updatePermission(TPermission permission);

	void deletePermission(Integer id);

	TPermission getPermissionById(Integer id);

	void assignPermissionForRole(Integer rid, String permissionIds);

	/**
	 * 查询某个角色对应的权限
	 * @param rid
	 * @return
	 */
	List<TPermission> getRolePermissions(Integer rid);

	/**
	 * 按照权限id查出它可以操作的所有菜单
	 * @param permissionId 权限id
	 * @return
	 */
	List<TMenu> getMenusByPermissionId(Integer permissionId);

}

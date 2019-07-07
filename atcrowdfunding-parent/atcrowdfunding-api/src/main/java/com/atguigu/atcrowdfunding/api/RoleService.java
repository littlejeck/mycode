package com.atguigu.atcrowdfunding.api;

import java.util.List;

import com.atguigu.atcrowdfunding.bean.TRole;

public interface RoleService {

	/**
	 *  返回所有的role数据
	 * @return
	 */
	List<TRole> getAllRoles();

	/**
	 * 按照检索条件查询
	 * @param condition
	 * @return
	 */
	List<TRole> getAllRolesByCondition(String condition);

	/**
	 * 角色添加
	 * @param role
	 */
	void addRole(TRole role);

	/**
	 * 删除某个角色
	 * @param id
	 */
	void deleteRole(int id);

	/**
	 * 查询role
	 * @param id
	 * @return
	 */
	TRole getRoleById(Integer id);

	/**
	 * 修改角色
	 * @param role
	 */
	void updateRole(TRole role);

	List<TRole> getUserHasRoles(Integer id);

	List<TRole> getUserUnRoles(Integer id);

	/**
	 * 给用户分配指定角色
	 * @param uid
	 * @param rids
	 */
	void assignUserRole(Integer uid, String rids);

	void unAssignUserRole(Integer uid, String rids);

}

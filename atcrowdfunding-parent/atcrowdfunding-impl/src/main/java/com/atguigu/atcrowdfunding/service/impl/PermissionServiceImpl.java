package com.atguigu.atcrowdfunding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.atguigu.atcrowdfunding.api.PermissionService;
import com.atguigu.atcrowdfunding.bean.TMenu;
import com.atguigu.atcrowdfunding.bean.TPermission;
import com.atguigu.atcrowdfunding.bean.TRolePermission;
import com.atguigu.atcrowdfunding.bean.TRolePermissionExample;
import com.atguigu.atcrowdfunding.mapper.TMenuMapper;
import com.atguigu.atcrowdfunding.mapper.TPermissionMapper;
import com.atguigu.atcrowdfunding.mapper.TRolePermissionMapper;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	TPermissionMapper permissonMapper;
	
	@Autowired
	TRolePermissionMapper rolePermissonMapper;
	
	@Autowired
	TMenuMapper menuMapper;

	@Override
	public List<TPermission> getAllPermissions() {
		// TODO Auto-generated method stub
		return permissonMapper.selectByExample(null);
	}

	@Override
	public void savePermission(TPermission permission) {
		// TODO Auto-generated method stub
		permissonMapper.insertSelective(permission);
	}

	@Override
	public void updatePermission(TPermission permission) {
		// TODO Auto-generated method stub
		permissonMapper.updateByPrimaryKeySelective(permission);
	}

	@Override
	public void deletePermission(Integer id) {
		// TODO Auto-generated method stub
		permissonMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TPermission getPermissionById(Integer id) {
		// TODO Auto-generated method stub
		return permissonMapper.selectByPrimaryKey(id);
	}

	
	
	/**
	 * Integer rid,角色id
	 *  String permissionIds 权限id，多个用,分割
	 */
	@Override
	public void assignPermissionForRole(Integer rid, String permissionIds) {
		List<Integer> permissionIdList = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(permissionIds)) {
			String[] split = permissionIds.split(",");
			for (String string : split) {
				Integer pid = Integer.parseInt(string);
				permissionIdList.add(pid);
			}
			
			//1、插入之前先删除，这个角色的全部删除。
			TRolePermissionExample example = new TRolePermissionExample();
			example.createCriteria().andRoleidEqualTo(rid);
			rolePermissonMapper.deleteByExample(example);
			
			//插入角色对应的所有权限,
			rolePermissonMapper.insertPermissonsToRoleBatch(rid,permissionIdList);
			
		}
	}

	@Override
	public List<TPermission> getRolePermissions(Integer rid) {
		// TODO Auto-generated method stub
		List<TPermission> permissions = permissonMapper.selectRolePermissions(rid);
		return permissions;
	}

	@Override
	public List<TMenu> getMenusByPermissionId(Integer permissionId) {
		// TODO Auto-generated method stub
		return menuMapper.getMenusByPermissionId(permissionId);
	}

}

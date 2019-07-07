package com.atguigu.atcrowdfunding.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.atguigu.atcrowdfunding.api.RoleService;
import com.atguigu.atcrowdfunding.bean.TAdminRole;
import com.atguigu.atcrowdfunding.bean.TAdminRoleExample;
import com.atguigu.atcrowdfunding.bean.TRole;
import com.atguigu.atcrowdfunding.bean.TRoleExample;
import com.atguigu.atcrowdfunding.mapper.TAdminRoleMapper;
import com.atguigu.atcrowdfunding.mapper.TRoleMapper;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	TRoleMapper roleMapper;
	
	@Autowired
	TAdminRoleMapper adminRoleMapper;
	
	@Override
	public List<TRole> getAllRoles() {
		// TODO Auto-generated method stub
		return roleMapper.selectByExample(null);
	}

	@Override
	public List<TRole> getAllRolesByCondition(String condition) {
		// TODO Auto-generated method stub
		TRoleExample example = new TRoleExample();
		if(!StringUtils.isEmpty(condition)) {
			example.createCriteria().andNameLike("%"+condition+"%");
		}
		
		return roleMapper.selectByExample(example);
	}

	@Override
	public void addRole(TRole role) {
		// TODO Auto-generated method stub
		roleMapper.insertSelective(role);
	}

	@Override
	public void deleteRole(int id) {
		// TODO Auto-generated method stub
		roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public TRole getRoleById(Integer id) {
		// TODO Auto-generated method stub
		
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateRole(TRole role) {
		// TODO Auto-generated method stub
		roleMapper.updateByPrimaryKey(role);
	}

	/**
	 * 查询用户已有的角色
	 */
	@Override
	public List<TRole> getUserHasRoles(Integer id) {
		// TODO Auto-generated method stub
		/**
		 * select r.* from t_role r left join `t_admin_role` ar on ar.roleid=r.`id` where ar.adminid=2
		 */
		List<TRole> roles = roleMapper.getUserHasRoles(id);
		return roles;
	}

	/**
	 * 查询用户没有的角色
	 */
	@Override
	public List<TRole> getUserUnRoles(Integer id) {
		// TODO Auto-generated method stub
		List<TRole> roles = roleMapper.getUserUnRoles(id);
		return roles;
	}

	/**
	 *   uid : 5
	 *   rids: 1,4,6,7,8
	 *   
	 */
	@PreAuthorize("hasAuthority('user:assign:role')")
	@Override
	public void assignUserRole(Integer uid, String rids) {
		// TODO Auto-generated method stub
		List<Integer> ridsList = new ArrayList<Integer>();
		if(!StringUtils.isEmpty(rids)) {
			String[] strings = rids.split(",");
			for (String string : strings) {
				Integer rid = Integer.parseInt(string);
				ridsList.add(rid);
			}
		}
		
		
		//插入之前先尝试删除。
		TAdminRoleExample example = new TAdminRoleExample();
		example.createCriteria().andAdminidEqualTo(uid).andRoleidIn(ridsList);
		adminRoleMapper.deleteByExample(example);
		
		//批量插入
		adminRoleMapper.insertBatchUserRole(uid,ridsList);
		
	}

	
	@PreAuthorize("hasAuthority('user:assign:role')")
	@Override
	public void unAssignUserRole(Integer uid, String rids) {
		// TODO Auto-generated method stub
		List<Integer> ridsList = new ArrayList<Integer>();
		if(!StringUtils.isEmpty(rids)) {
			String[] strings = rids.split(",");
			for (String string : strings) {
				Integer rid = Integer.parseInt(string);
				ridsList.add(rid);
			}
		}
		
		
		//删除。
		TAdminRoleExample example = new TAdminRoleExample();
		example.createCriteria().andAdminidEqualTo(uid).andRoleidIn(ridsList);
		adminRoleMapper.deleteByExample(example);
	}

}

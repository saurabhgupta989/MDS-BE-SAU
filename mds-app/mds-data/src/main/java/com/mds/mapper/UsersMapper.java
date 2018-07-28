package com.mds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mds.model.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	public List<Users> findAll();

	@Insert("insert into users(name,salary) values (#{name}, #{salary})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	public Integer insert(Users user);

}

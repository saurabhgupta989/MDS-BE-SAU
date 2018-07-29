package com.mds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mds.model.BlogEntry;
import com.mds.model.Users;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	public List<Users> fetchAllUsers();

	@Insert("insert into users(name,salary) values (#{name}, #{salary})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	public Integer insert(Users user);

	@Select("select e.id, e.title, e.body, e.postDate, t.id , t.name as tag_name, t.shortName as tag_shortName, t.description as tag_description from blog_entry e LEFT JOIN blog_entry_tag ON e.id=blog_entry_tag.blog_entry_id LEFT JOIN tag t ON blog_entry_tag.tag_id=t.id")
	public List<BlogEntry> findTagJoin();

}

package com.mds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.mds.model.BlogEntry;
import com.mds.model.Dog;
import com.mds.model.User;

@Mapper
public interface UsersMapper {

	@Select("select * from users")
	public List<User> fetchAllUsers();

	@Select("select * from users")
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "salary", column = "salary"),
			@Result(property = "dogs", javaType = List.class, column = "id", many = @Many(select = "findDogsByUserId")) })
	public List<User> fetchAllUsersWithDogs();

	@Insert("insert into users(name,salary) values (#{name}, #{salary})")
	@SelectKey(statement = "select LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	public Integer insertUser(User user);

	@Update("update users set name=#{name} ,salary=#{salary} where id=#{id}")
	public Integer updateUser(User user);

	@Select("SELECT * FROM USERS WHERE ID = #{id}")
	@Results(value = { @Result(property = "id", column = "id"), @Result(property = "name", column = "name"),
			@Result(property = "salary", column = "salary"),
			@Result(property = "dogs", javaType = List.class, column = "id", many = @Many(select = "findDogsByUserId")) })
	public User retrieveUserById(Integer id);

	@Select("SELECT * FROM DOG WHERE PERSON_ID = #{id}")
	@Results(value = { @Result(property = "name", column = "name"), @Result(property = "dogId", column = "id") })
	List<Dog> findDogsByUserId(Integer id);

	@Select("select e.id, e.title, e.body, e.postDate, t.id , t.name as tag_name, t.shortName as tag_shortName, t.description as tag_description from blog_entry e LEFT JOIN blog_entry_tag ON e.id=blog_entry_tag.blog_entry_id LEFT JOIN tag t ON blog_entry_tag.tag_id=t.id")
	public List<BlogEntry> findTagJoin();

}

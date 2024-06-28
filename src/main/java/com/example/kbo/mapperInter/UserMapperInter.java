package com.example.kbo.mapperInter;

import com.example.kbo.data.dto.UserDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapperInter {

    @Select("select count(*) from user where userid=#{searchid}")
    public int getIdCheckCount(String searchid);

    @Insert("""
                insert into user(userid, userpw, name, nickname, hp, email, joinday) 
                values(#{userid}, #{userpw}, #{name}, #{nickname}, #{hp}, #{email}, now())
                """)
    public void insertUser(UserDto dto);


    @Select("SELECT COUNT(*) FROM user")
    public int getTotalCount();

    @Select("select * from user order by num desc")
    public List<UserDto> getAllUsers();

    @Select("select * from user where num=#{num}")
    public UserDto getData(int num);

    @Select("select * from user where userid=#{userid}")
    public UserDto getDataById(String userid);

    @Update("update user set profile=#{photo} where num=#{num}")
    public void updatePhoto(Map<String, Object> map);

    @Update("update user set userpw=#{pw}, nickname=#{nickname}, profile=#{profile}, hp=#{hp}, email=#{email} where num=#{num}")
    public void updateUser(UserDto dto);

/*
    @Delete("delete from user where num=#{num}")
    public void deleteUser(int num);
*/

    @Select("select count(*) from user where num=#{num} and userpw=#{pw}")
    public int isEqualPassCheck(Map<String, Object> map);

    @Select("""
            select count(*) from user where userid=#{myid} and userpw=#{pass}
            """)
    public int isloginCheck(String myid, String pass);

    @Select("select num from user where userid = #{id}")
    public int getNum(String id);

}

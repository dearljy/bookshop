package com.tjt.books.dao;


import com.tjt.books.entity.Member;

public interface MemberDao {
    //提供一个用户名，返回对应的member对象
    public Member queryMemberByUsername(String username);
    //保存一个member对象到数据库/member表
    public int saveMember(Member member);
    //根据用户名，密码判断会员是否存在，或者是否合法
    public Member queryMemberByUsernameAndPassword(String username,String password);
}

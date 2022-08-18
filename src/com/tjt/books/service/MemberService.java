package com.tjt.books.service;


import com.tjt.books.entity.Member;

public interface MemberService {
    //注册用户
    public boolean registerMember(Member member);

    //判断用户是否存在
    public boolean isExistsUsername(String username);

    //判断会员是否合法
    public Member login(Member member);
}

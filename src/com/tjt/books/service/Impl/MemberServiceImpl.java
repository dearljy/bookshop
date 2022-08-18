package com.tjt.books.service.Impl;


import com.tjt.books.dao.Impl.MemberDAOImpl;
import com.tjt.books.dao.MemberDao;
import com.tjt.books.entity.Member;
import com.tjt.books.service.MemberService;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDAO = new MemberDAOImpl();

    @Override
    public boolean registerMember(Member member) {
        int i = memberDAO.saveMember(member);
        return i==1 ? true:false;
    }

    /**
     * 判断用户名是否存在，
     * @param username 用户名
     * @return 如果存在返回ture，否则返回false
     */
    @Override
    public boolean isExistsUsername(String username) {
        //技巧：
        //如果看某个方法 ctrl+b =》定位到MemberDAo 编译类型的方法
        //如果使用ctrl+alt+b =>实现类的方法
        Member member = memberDAO.queryMemberByUsername(username);
        return member==null ? false : true;
    }

    /**
     * 根据传入的member对象存在于数据表中，返回对应的member对象
     * @param member
     * @return 存在返回member对象，不存在返回null
     */
    @Override
    public Member login(Member member) {
        Member member1 = memberDAO.queryMemberByUsernameAndPassword(member.getUsername(), member.getPassword());
        return member1;
    }



}

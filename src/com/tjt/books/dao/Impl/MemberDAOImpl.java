package com.tjt.books.dao.Impl;


import com.tjt.books.dao.BasicDAO;
import com.tjt.books.dao.MemberDao;
import com.tjt.books.entity.Member;

public class MemberDAOImpl extends BasicDAO<Member> implements MemberDao {
    /**
     * 根据username，查询数据表 有则返回member对象，无则返回null
     * @param username 用户名
     * @return 返回member对象，无则返回null
     */
    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "select * from member where username = ?";
        Member member = querySingle(sql, Member.class, username);
        return member;
    }

    /**
     * 保存一个会员
     * @param member 传入member对象
     * @return 返回-1 就是失败，返回其他数字就是返回受影响的行数
     */
    @Override
    public int saveMember(Member member) {
        String sql = "insert into member values(null,?,MD5(?),?)";
        return update(sql, member.getUsername(), member.getPassword(), member.getEmail());
    }

    /**
     * 根据用户名，密码 查询一个member对象
     * @param username
     * @param password
     * @return 查询成功返回member对象，反正返回null
     */
    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {
        String sql = "select * from member where username = ? and password = MD5(?)";
        Member member = querySingle(sql, Member.class, username, password);
        return member;
    }
}

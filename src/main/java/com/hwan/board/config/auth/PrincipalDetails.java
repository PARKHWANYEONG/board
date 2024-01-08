package com.hwan.board.config.auth;

import com.hwan.board.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 *  스프링 시큐리티에서 로그인 요청을 가로채서 진행
 */
public class PrincipalDetails implements UserDetails {

    private  User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    // 계정의 권한 목록을 리턴 (권한이 여러개일 경우 루프를 사용하여 collection에 넣기)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(() -> user.getRoleValue());

        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정 만료 여부 (true : 만료 X)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠금 여부 (true : 잠금 X)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 비밀번호 만료 여부 (true : 만료 X)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 여부 (true : 활성화)
    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.felece.ticket.auth;

import com.felece.ticket.dao.UserDao;
import com.felece.ticket.model.UserModel;
import com.felece.ticket.model.UserRoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userDao.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Username not found"));
        return new User(userModel.getUserName(), userModel.getPassword(), roleToAuthority(userModel.getRole()));
    }

    private Collection<GrantedAuthority> roleToAuthority(UserRoleModel role){
        Collection<GrantedAuthority> roleCollection = new ArrayList<>();
        roleCollection.add(new SimpleGrantedAuthority(role.getRoleName()));
        return roleCollection;
    }
}

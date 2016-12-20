package netcracker.school.service;

import netcracker.school.models.ReaderPassport;
import netcracker.school.models.User;
import netcracker.school.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class LibraryUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String useremail) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(useremail);
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        System.out.println("loadUserByUsername:"+user);
        //user.getState().equals("Active")
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserRole userRole : user.getUserRoles()){
            System.out.println("UserProfile : "+userRole);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getRole()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }

}
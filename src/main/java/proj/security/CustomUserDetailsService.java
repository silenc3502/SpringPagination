package proj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.java.Log;
import proj.entity.Member;
import proj.repository.MemberRepository;

@Log
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("userName : " + userName);

        Member member = repository.findByUserId(userName).get(0);

        log.info("member : " + member);

        return member == null ? null : new CustomUser(member);
    }
}
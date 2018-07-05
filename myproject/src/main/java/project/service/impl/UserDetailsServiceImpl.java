package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.entity.Writer;
import project.mapper.WriterMapper;
import project.repository.WriterRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired private WriterRepository writerRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Writer writer = writerRepository.findByEmail(s);
        if (writer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return WriterMapper.toSecurityUser(writer);
    }
}

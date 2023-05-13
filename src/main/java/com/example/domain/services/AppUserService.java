package com.example.domain.services;

import com.example.domain.dao.identity.IRoleRepository;
import com.example.domain.dao.identity.IUserRepository;
import com.example.domain.models.Identity.AppRole;
import com.example.domain.models.Identity.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    AppUser _defaultUser;
    public AppUserService() {

        AppUser user = new AppUser();
        user.setUsername("user");
        user.setPassword("password");
        user.setRoles(Collections.singleton(new AppRole(1L, "ROLE_USER")));
        _defaultUser=user;
    }

    //TO DO: for hex crypto password
    //@Autowired
    //BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findByName(username);

        if(user == null){
            return _defaultUser;
            //throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    public AppUser findUserById(Long id){

        Optional<AppUser> user = userRepository.findById(id);
        return user.orElse(new AppUser());
    }

    public Iterable<AppUser> allUsers(){

        return userRepository.findAll();
    }

    public boolean saveUser(AppUser user){

        //Username not unique
        if(userRepository.findByName(user.getUsername()) != null){

            return false;
        }

        user.setRoles(Collections.singleton(new AppRole(1L, "ROLE_USER")));

        //////////////////////////////////
        //  TO DO: hash crypto password here
        //////////////////////////////////
        // user.setPassword= passwordEncoder.encode(user.getPassword);
        //////////////////////////////////

        userRepository.save(user);

        return true;
    }

    public boolean deleteUser(Long id){

        if(userRepository.existsById(id)){

            userRepository.deleteById(id);
            return true;
        }

        return false;
    }

    public List<AppUser> getUsers_GT(Long minId){

        return entityManager.createQuery("SELECT u FROM AppUser u WHERE u.id > :param", AppUser.class)
                .setParameter("param", minId).getResultList();
    }

}

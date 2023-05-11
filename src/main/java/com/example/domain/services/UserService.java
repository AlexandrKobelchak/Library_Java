package com.example.domain.services;

import com.example.domain.dao.identity.IRoleRepository;
import com.example.domain.dao.identity.IUserRepository;
import com.example.domain.models.Identity.Role;
import com.example.domain.models.Identity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    //TO DO: for hex crypto password
    //@Autowired
    //BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByName(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
    public User findUserById(Long id){

        Optional<User> user = userRepository.findById(id);
        return user.orElse(new User());
    }

    public Iterable<User> allUsers(){

        return userRepository.findAll();
    }

    public boolean saveUser(User user){

        //Username not unique
        if(userRepository.findByName(user.getUsername()) != null){

            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));

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

    public List<User> getUsers_GT(Long minId){

        return entityManager.createQuery("SELECT u FROM User u WHERE u.id > :param", User.class)
                .setParameter("param", minId).getResultList();
    }

}

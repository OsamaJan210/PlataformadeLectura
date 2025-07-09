package com.fundacioesplai.lectura.service;

import java.util.List;

<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;

>>>>>>> f5df49efce11ad57e42e2873eee18a232fffb6cf
import com.fundacioesplai.lectura.dto.LoginReq;
import com.fundacioesplai.lectura.model.User;

public interface UserService {
    public User createUser(User req);

    public boolean userExsistByEmail(String email);

    public User loginUser(LoginReq req);
    public List<User> getallUser();
    public User getUserById(Integer id );

    public User findByUsername(String username);

    List<User> findByUsernameNot(String username);

}

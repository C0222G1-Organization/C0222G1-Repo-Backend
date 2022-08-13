package internet.com.services.user.impl;


import internet.com.entity.user.AppUser;
import internet.com.repository.user_repo.IUserRepository;
import internet.com.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserRepository userRepository;

    /**
     * Create by HoangHN
     * Date create: 10/8/2022
     * function: findByUsername
     * @param name
     * @return
     */
    @Override
    public Optional<AppUser> findByUsername(String name) {
        return userRepository.findByUsername(name);
    }



}

package internet.com.services.user.impl;


import internet.com.entity.user.AppRole;
import internet.com.entity.user.UserRole;
import internet.com.repository.user_repo.IRoleRepository;
import internet.com.services.user.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    /**
     * Create by HoangHN
     * Date create: 10/08/2022
     * function: find by name
     * @param name
     * @return
     */
    @Override
    public Optional<AppRole> findByName(UserRole name) {
        return roleRepository.findByName(name);
    }


}

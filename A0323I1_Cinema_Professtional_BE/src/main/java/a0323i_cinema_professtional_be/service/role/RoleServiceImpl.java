package a0323i_cinema_professtional_be.service.role;

import a0323i_cinema_professtional_be.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository repository;
}

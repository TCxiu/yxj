package www.yxj.service.impl;

import www.yxj.mapper.UserMapper;
import www.yxj.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www.yxj.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }
}

package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.model.mapper.UserMapper;
import com.notimplement.happygear.repositories.RoleRepository;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.UserService;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    @Override
    public List<UserDto> listAllUserDto() {
        List<User> listUser = userRepo.findAll();
        List<UserDto> listUserDto = new ArrayList<>();
        listUser.forEach(u -> listUserDto.add(UserMapper.toUserDto(u)));
        return listUserDto;
    }

    @Override
    public List<User> listAllUser() {
        return userRepo.findAll();
    }

    @Override
    public UserDto registerAcc(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto loginAcc(UserDto userDto) {
        String username = userDto.getUserName();
        String password = userDto.getPassword();
        throw new NotYetImplementedException();
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public List<UserDto> listAllActiveUser() {
//        return userRepo.findAllUserWithActiveStatus().stream().map(userMapper::toUserDto).collect(Collectors.toList());
        return null;
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = toUser(userDto);
//        return userMapper.toUserDto(userRepo.save(user));
        return null;
    }

    @Override
    public void delete(String username) {
        userRepo.deleteByUserName(username);
    }

    @Override
    public UserDto getUserByName(String name) {
//        return userMapper.toUserDto(userRepo.findByUserName(name));
        return null;
    }

    @Override
    public List<UserDto> searchByFullName(String name) {
//        return userRepo.findByFullNameContainingIgnoreCase(name).stream().map(userMapper::toUserDto).collect(Collectors.toList());
        return null;
    }

    private User toUser(UserDto dto){
        User u = new User();
        u.setUserName(dto.getUserName());
        u.setPassword(dto.getPassword());
        u.setFullName(dto.getFullName());
        u.setAddress(dto.getAddress());
        u.setEmail(dto.getEmail());
        u.setPhoneNumber(dto.getPhoneNumber());
        u.setStatus(dto.getStatus());
        u.setGender(dto.getGender());
        u.setRole(roleRepo.findById(dto.getRoleId()).get());
        return u;
    }
}

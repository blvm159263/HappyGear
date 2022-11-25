package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.AccountDto;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.model.mapper.UserMapper;
import com.notimplement.happygear.repositories.RoleRepository;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<UserDto> getAllUserDto() {
        List<User> listUser = userRepository.findAll();
        List<UserDto> listUserDto = new ArrayList<>();
        listUser.forEach(u -> listUserDto.add(UserMapper.toUserDto(u)));
        return listUserDto;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public AccountDto signupAcc(UserDto userDto) {
        return null;
    }

    @Override
    public AccountDto loginAcc(UserDto userDto) {
        String username = userDto.getUserName();
        String password = userDto.getPassword();
        User user = userRepository.findByUserNameAndPassword(username,password);
        if(user!=null){
            AccountDto acc = new AccountDto(username,password);
            return acc;
        }
        return null;
    }

    @Override
    public UserDto getByUserName(String username) {
        return UserMapper.toUserDto(userRepository.findByUserName(username));
    }

    @Override
    public List<UserDto> getAllActiveUser() {
        List<User> listUser = userRepository.findAllUserWithActiveStatus();
        List<UserDto> listUserDto = new ArrayList<>();
        listUser.forEach(u -> listUserDto.add(UserMapper.toUserDto(u)));
        return listUserDto;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = toUser(userDto);
        return UserMapper.toUserDto(userRepository.save(user));
    }

    @Override
    public UserDto deleteUser(String username) {
        User user = userRepository.findByUserName(username);
        if(user!=null){
            User savedUser = new User(
                    user.getUserName(),
                    user.getFullName(),
                    user.getPassword(),
                    user.getAddress(),
                    user.getEmail(),
                    user.getPhoneNumber(),
                    false,
                    user.getGender(),
                    user.getRole()
            );
            userRepository.save(savedUser);
            return UserMapper.toUserDto(savedUser);
        }
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto, String username) {
        User user = userRepository.findByUserName(username);
        if(user!=null){
            User updatedUser = toUser(userDto);
            userRepository.save(updatedUser);
            return UserMapper.toUserDto(updatedUser);
        }
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = toUser(userDto);
        if(user!=null){
            userRepository.save(user);
            return UserMapper.toUserDto(user);
        }
        return null;
    }

    @Override
    public List<UserDto> searchByFullName(String name) {
        List<User> listUser = userRepository.findByFullNameContainingIgnoreCase(name);
        List<UserDto> listUserDto = new ArrayList<>();
        listUser.forEach(u -> listUserDto.add(UserMapper.toUserDto(u)));
        return listUserDto;
    }

    private User toUser(UserDto dto){
        if(dto!=null){
            User u = new User();
            u.setUserName(dto.getUserName());
            u.setPassword(dto.getPassword());
            u.setFullName(dto.getFullName());
            u.setAddress(dto.getAddress());
            u.setEmail(dto.getEmail());
            u.setPhoneNumber(dto.getPhoneNumber());
            u.setStatus(dto.getStatus());
            u.setGender(dto.getGender());
            u.setRole(roleRepository.findById(dto.getRoleId()).orElse(null));
            return u;
        }
        return null;
    }
}

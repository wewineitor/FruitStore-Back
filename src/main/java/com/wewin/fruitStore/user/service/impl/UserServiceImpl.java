package com.wewin.fruitStore.user.service.impl;

import com.wewin.fruitStore.user.dto.UserDTO;
import com.wewin.fruitStore.user.entity.User;
import com.wewin.fruitStore.user.repository.UserRepository;
import com.wewin.fruitStore.user.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    private void encodeAndSaveUser(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public void register(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        encodeAndSaveUser(user);
    }

    @Override
    public UserDTO login(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return modelMapper.map(user, UserDTO.class);
        }
        return null;
    }

    @Override
    public void updateUser(Long id, UserDTO userDTO) {
        User existingUser = userRepository.findUserById(id);
        if (existingUser != null) {
            existingUser.setName(userDTO.getName());
            existingUser.setLastname(userDTO.getLastname());
            existingUser.setAddress(userDTO.getAddress());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPhone(userDTO.getPhone());
            if (userDTO.getPassword() != null && !userDTO.getPassword().isEmpty()) {
                String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
                existingUser.setPassword(encodedPassword);
            }
            userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

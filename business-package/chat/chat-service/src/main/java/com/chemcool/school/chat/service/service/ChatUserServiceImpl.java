package com.chemcool.school.chat.service.service;

import com.chemcool.school.chat.service.models.ChatUser;
import com.chemcool.school.chat.service.repository.ChatUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatUserServiceImpl implements ChatUserService{

    private final ChatUserRepository chatUserRepository;

    public ChatUserServiceImpl(ChatUserRepository chatUserRepository) {
        this.chatUserRepository = chatUserRepository;
    }

    @Override
    public List<ChatUser> findAllUsers() {
        return chatUserRepository.findAll();
    }

    @Override
    public ChatUser findByUserName(String name){
        ChatUser user = null;
        Optional<ChatUser> searchUserResult = chatUserRepository.findByUserName(name);

        if(searchUserResult.isPresent()){
            user = searchUserResult.get();
        }else{
            throw new RuntimeException("Could not find user by name: " + name);
        }
        return user;
    }
}

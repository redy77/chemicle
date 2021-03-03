package com.chemcool.school.listener;

import com.chemcool.school.dto.GotFromFrontEnd;
import com.chemcool.school.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CommentListener {

    @Autowired
    ServiceInterface serviceInterface;

    @KafkaListener(topics = "KafkaComment", groupId = "group_json1",containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(GotFromFrontEnd gotFromFrontEnd){
        System.out.println("Consume Json message : "+ gotFromFrontEnd);
        serviceInterface.addComment(gotFromFrontEnd);
    }

}

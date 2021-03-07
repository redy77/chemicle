package com.chemcool.school.fakefrontend;

import com.chemcool.school.dto.GotFromFrontEnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForTesting {

    @Autowired
    KafkaTemplate<String, GotFromFrontEnd>  kafkaTemplate;

    @GetMapping("/publish/{comment}/{author}/{date}/{lessonId}")
    public String customPost(@PathVariable String comment,
                             @PathVariable String author,
                             @PathVariable String date,
                             @PathVariable Long lessonId){
        kafkaTemplate.send("KafkaComment",new GotFromFrontEnd(comment,author,date,lessonId));
        return "Published Successfully";
    }

}
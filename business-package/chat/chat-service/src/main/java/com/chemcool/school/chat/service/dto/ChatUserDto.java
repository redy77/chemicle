package com.chemcool.school.chat.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatUserDto {
    public String id;
    public String name;
    public String role;
}

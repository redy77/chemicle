package com.chemcool.school.constructor.domain.singleselect.endpoints;

import com.chemcool.school.constructor.domain.singleselect.dto.SingleSelectTaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@RequestMapping("/v1/single_select/task")
public class SingleSelectController {

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public SingleSelectTaskDto addUser(@RequestBody SingleSelectTaskDto singleSelectTaskDto) {
        return singleSelectTaskDto;

    }


}

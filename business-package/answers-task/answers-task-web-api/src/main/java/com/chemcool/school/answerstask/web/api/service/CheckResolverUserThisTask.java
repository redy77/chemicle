package com.chemcool.school.answerstask.web.api.service;

import com.chemcool.school.answerstask.service.UserAnswersCorrectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CheckResolverUserThisTask {
    private final UserAnswersCorrectService userAnswersCorrectService;

    public boolean checkResolverUserThisTask(String taskId, String userId) {
        List<String> allUserResolvedTaskId = userAnswersCorrectService.getAllUserResolvedTaskId(userId);
        boolean flag = false;
        for (String iter : allUserResolvedTaskId) {
           flag = iter.equals(taskId);
        }
        return flag;
    }
}

package com.chemcool.school.tasks.chemequations.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

@Slf4j
@Service
public class ChemEquationsTaskAnswerCheckService {
    private boolean[] result;
    private Set<String> bufRightAnswer;
    private Set<String> bufUserAnswer;

    public static void main(String[] args) {
        String trueAnswer = "CuSO4 + 2NaOH → Cu(OH)2↓+ Na2SO4↑";
        String userAnswer = "CuSO4 + 2NaOH → Na2SO4↑ + Cu(OH)2↓";
        ChemEquationsTaskAnswerCheckService checker = new ChemEquationsTaskAnswerCheckService();

        System.out.println(Arrays.toString(checker.checkAnswer(
                trueAnswer.replaceAll(" ", ""),
                userAnswer.replaceAll(" ", "")))
        );
    }

    public ChemEquationsTaskAnswerCheckService() {
        this.result = new boolean[4];
        this.bufRightAnswer = new TreeSet();
        this.bufUserAnswer = new TreeSet();
    }

    public boolean[] checkAnswer(String rightAnswer, String userAnswer) {

        result[0] = check(rightAnswer, userAnswer);
        log.info("Проверка уравнения без учета порядка: " + result[0]);

        result[1] = checkRegister(rightAnswer, userAnswer);
        log.info("Проверка уравнения без учета регистра: " + result[1]);

        result[2] = checkAgrStatus(rightAnswer, userAnswer);
        log.info("Проверка уравнения без агрегатного состояния: " + result[2]);

        result[3] = checkSymbol(rightAnswer, userAnswer);
        log.info("Проверка символа сравнения: " + result[3]);

        return result;
    }

    //обнуляем буферные переменные
    private void bufClear() {
        bufUserAnswer.clear();
        bufRightAnswer.clear();
    }

    //проверка элементов без учета порядка
    private boolean check(String r, String u) {
        bufClear();
        bufRightAnswer.addAll(Arrays.asList(r.split("[→=⇄↔+]")));
        bufUserAnswer.addAll(Arrays.asList(u.split("[→=⇄↔+]")));
        return bufRightAnswer.equals(bufUserAnswer);
    }

    //без учета регистра
    private boolean checkRegister(String r, String u) {
        return check(r.toLowerCase(), u.toLowerCase());
    }

    //без учета агрегатного состояния продуктов реакции
    private boolean checkAgrStatus(String r, String u) {
        r = r.replaceAll("[↓↑]", "");
        u = u.replaceAll("[↓↑]", "");
        return check(r, u) || checkRegister(r, u);
    }

    //проверка вида реакции (знака между левой и правой частью уравнения)
    private boolean checkSymbol(String r, String u) {
        r = r.replaceAll("[^→=⇄↔]", "");
        u = u.replaceAll("[^→=⇄↔]", "");
        return r.equals(u);
    }
}

package com.chemcool.school.tasks.chemequations.service;

import org.springframework.stereotype.Service;

@Service
public class ChemEquationsTaskAnswerCheckService {
    private String bufRightAnswer;
    private String bufUserAnswer;

    public static void main(String[] args) {
        String r = "CuSO4 + 2NaOH → Cu(OH)2↓+ Na2SO4";
        String u = "CuSO4 + 2NaOH → u(OH)2↓+ Na2SO4";
        ChemEquationsTaskAnswerCheckService checker = new ChemEquationsTaskAnswerCheckService();
        System.out.println(checker.checkAnswer(r.replaceAll(" ",""),u.replaceAll(" ","")));
    }

    public boolean checkAnswer(String rightAnswer, String userAnswer) {
        this.bufRightAnswer = rightAnswer;
        this.bufUserAnswer = userAnswer;

        //если все идеально верно
        if (check()) {
            System.out.println("Заебись, четко");
            System.out.println(rightAnswer + " = " + userAnswer);
            return true;
        }

        //если верно все кроме регистра элементов
        if (checkRegister()) {
            System.out.println("Некоректно прописаны элементы.");
            System.out.println(rightAnswer + " != " + userAnswer);
            return true;
        }

        // если проблемы с осадком
        if(checkAgrStatus()) {
            System.out.println("Ошибка в агрегатном состоянии продуктов реакции.");
            System.out.println(rightAnswer + " != " + userAnswer);
            return true;
        }

        //если верно все кроме знака
        if (checkSymbol()) { // нужно допилить регулярку
            System.out.println("Неверно указан вид реакции. (Знак между левой и правой частью уравнения)");
            System.out.println(rightAnswer + " != " + userAnswer);
            return true;
        }

        System.out.println("Что то не так");
        System.out.println(bufRightAnswer +" != "+ bufUserAnswer );
        return false;
    }

    private boolean check(){
        if (bufRightAnswer.equals(bufUserAnswer)) {
            return true;
        }
        return false;
    }
    private boolean checkRegister(){
        bufRightAnswer = bufRightAnswer.toLowerCase();
        bufUserAnswer = bufUserAnswer.toLowerCase();
        return check();
    }

    private boolean  checkSymbol(){
        bufRightAnswer = bufRightAnswer.replaceAll("[→=⇄↔]","."); // нужно допилить регулярку
        bufUserAnswer = bufUserAnswer.replaceAll("[→=⇄↔]",".");
        return check();
    }

    private boolean checkAgrStatus(){
        bufRightAnswer = bufRightAnswer.replaceAll("[↓↑]",".."); // нужно допилить регулярку
        bufUserAnswer = bufUserAnswer.replaceAll("[↓↑]","..");
        return check();
    }
}

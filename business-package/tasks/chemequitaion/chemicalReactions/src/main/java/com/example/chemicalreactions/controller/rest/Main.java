package com.example.chemicalreactions.controller.rest;

import com.example.chemicalreactions.domein.ChemicalReaction;
import com.example.chemicalreactions.service.ChemicalReactionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s = "H";
        String s2 = "HH";
        try {
            System.out.println(s.indexOf(s2));
        } catch (Exception e){
            System.out.println(e);
        }

    }
}

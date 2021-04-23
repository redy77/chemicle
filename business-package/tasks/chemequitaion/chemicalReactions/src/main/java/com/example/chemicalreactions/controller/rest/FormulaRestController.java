package com.example.chemicalreactions.controller.rest;


import com.example.chemicalreactions.domein.Atom;
import com.example.chemicalreactions.domein.ChemicalReaction;
import com.example.chemicalreactions.domein.Molecule;
import com.example.chemicalreactions.service.AtomService;
import com.example.chemicalreactions.service.ChemicalReactionService;
import com.example.chemicalreactions.service.MoleculeService;
import org.dom4j.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/formula/rest")
public class FormulaRestController {

    private final AtomService atomService;

    private final ChemicalReactionService chemicalReactionService;

    private final MoleculeService moleculeService;

    public FormulaRestController(AtomService atomService,
                                 ChemicalReactionService chemicalReactionService,
                                 MoleculeService moleculeService) {
        this.atomService = atomService;
        this.chemicalReactionService = chemicalReactionService;
        this.moleculeService = moleculeService;
    }

    //контроллер для поиска атома по его символу который приходит с фронта
    @PostMapping("/atom")
    public String poiskAtom(@RequestBody String stringAtom) {
        List<Atom> atoms = atomService.findAllAtom();
        for (Atom atom : atoms){
            if (stringAtom.equals(atom.getSymbol())){
                return atom.toString();
            }
        }
        String s = "такой атом не найден";
        return s;
    }

    //контроллер для поиска молекулы по присланным атомам
    @PostMapping("/molecula")
    public String poiskMolecula(@RequestBody String stringMolecula) {
        String[] strMol = stringMolecula.split(" ");
        List<Molecule> molecules = moleculeService.findAllMolecule();
        StringBuffer otvet = new StringBuffer();
        for (Molecule molecule : molecules){
            if (molecule.getChemicalFormulaMolecule().contains(strMol[0])) {
                if (molecule.getChemicalFormulaMolecule().contains(strMol[1])) {
                    otvet.append(molecule.getChemicalFormulaMolecule()).append("\n");
                }
            }
        }
        if (!otvet.toString().isEmpty()){
            return otvet.toString();
        }
        String s = "Хер";
        return s;
    }

//    //контроллер для общего поля
//    @PostMapping("/string")
//    public String creat(@RequestBody String stringFormula) {
//        StringBuffer str = new StringBuffer();
//        str.append(stringFormula);
//        return moleculeService.findByIdMolecule(stringFormula).toString();
//    }

//    public StringBuffer parsingStringFormulas(String strFormula){
//        System.out.println(strFormula);
//        StringBuffer strOtvet = new StringBuffer();
//        strOtvet.append("В Вашей фомуле присутствуют: \n");
//
//        String[] reagentsSent = strFormula
//                .substring(0, strFormula.indexOf("="))
//                .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", " ")
//                .split(" "); //реагенты присланной строки
//        String[] productsSent = strFormula
//                .substring(strFormula.indexOf("=") + 1)
//                .replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", " ")
//                .split(" "); //продукты присланной строки
//
//        ArrayList<String> suitableChemicalFormulas = new ArrayList<>(); //подходящие химические формулы
//
////        System.out.println(Arrays.toString(reagentsSent)); //присланные реагенты
////        System.out.println(Arrays.toString(productsSent)); //присланные продукты но не отчищенные от цифр молекул
//
//        for (String str : reagentsSent){
//            String[] strings = str.split(""); //массив из молекулы с номером
//            int znach = 0;
//            for (String str2 : strings){
//                //проверка что данный объект цифра
//                if (str2.chars().allMatch( Character::isDigit )) znach =+1; //
//            }
//
//            System.out.println(str.substring(znach));
//        }
//
//        return strOtvet;
//    }

}

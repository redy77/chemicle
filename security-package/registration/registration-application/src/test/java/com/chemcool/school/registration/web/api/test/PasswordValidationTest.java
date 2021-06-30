package com.chemcool.school.registration.web.api.test;

import com.chemcool.school.registration.web.api.dto.ResetPasswordDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class PasswordValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private void checkPassword(String password, boolean validates) {
        ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
        resetPasswordDto.setPassword(password);
        Set<ConstraintViolation<ResetPasswordDto>> violations = validator.validate(resetPasswordDto);
        Assert.assertEquals(violations.isEmpty(), validates);
    }

    @Test
    public void testSuccess() {
        checkPassword("Sb951357#", true);
    }

    @Test
    public void testFailLength() {
        checkPassword("Sb8$", false);
    }

    @Test
    public void testFailUpperCaseCharacter() {
        checkPassword("jkb8641fg$", false);
    }

    @Test
    public void testFailLowerCaseCharacter() {
        checkPassword("JKB8641FG$", false);
    }

    @Test
    public void testFailDigit() {
        checkPassword("JKBFGhlpuy$@", false);
    }

    @Test
    public void testFailSpecialCharacter() {
        checkPassword("JKB8641FGadeq", false);
    }

    @Test
    public void testFailWhiteSpace() {
        checkPassword("Sb95 1357@", false);
    }

    @Test
    public void testFailAlphabeticalSequence() {
        checkPassword("S95abcdef@", false);
    }

    @Test
    public void testFailNumericalSequence() {
        checkPassword("Sb123456@", false);
    }

    @Test
    public void testFailUSQwertySequence() {
        checkPassword("Sqwerty57@", false);
    }
}

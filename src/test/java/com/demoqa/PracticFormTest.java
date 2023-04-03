package com.demoqa;


import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticFormTest extends TestBase {
    @Test
    void successfulFillFormatTest () {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue("Dmitry");
        $("#lastName").setValue("Ochkasov");
        $("#userEmail").setValue("test@mail.ru");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1984")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__day--027").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/images.png"));
        $("#currentAddress").sendKeys("Moscow");
        $("#submit").scrollIntoView(false);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").scrollIntoView(false);
        $("#submit").click();

    }
}
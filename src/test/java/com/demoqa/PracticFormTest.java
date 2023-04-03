package com.demoqa;


import com.codeborne.selenide.Condition;
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
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText("1984")).click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__day--027").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/images.png"));
        $("#currentAddress").sendKeys("Moscow");
        $("#submit").scrollIntoView(false);
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").scrollIntoView(false);
        $("#submit").click();
        //Проверям форму Thanks for submitting the form//
        $(".table-responsive").shouldHave(Condition.text("Student Name Dmitry Ochkasov"));
        $(".table-responsive").shouldHave(Condition.text("Student Email test@mail.ru"));
        $(".table-responsive").shouldHave(Condition.text("Gender Male"));
        $(".table-responsive").shouldHave(Condition.text("Mobile 1234567890"));
        $(".table-responsive").shouldHave(Condition.text("Date of Birth 27 May,1984"));
        $(".table-responsive").shouldHave(Condition.text("Subjects Maths"));
        $(".table-responsive").shouldHave(Condition.text("Hobbies Sports"));
        $(".table-responsive").shouldHave(Condition.text("Picture images.png"));
        $(".table-responsive").shouldHave(Condition.text("Address Moscow"));
        $(".table-responsive").shouldHave(Condition.text("State and City Uttar Pradesh Lucknow"));
        $("#closeLargeModal").click();
    }
}
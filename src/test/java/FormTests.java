package tests;

import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @Test
    void successfulFormstTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Arthur");
        $("#lastName").setValue("Dent");
        $("#userEmail").setValue("the_hitchhikers_guide@galaxy.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("4242424242");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1979");
        $("[aria-label='Choose Friday, October 12th, 1979']").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Civic");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("History");
        $("#subjectsInput").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/resources/floppa.png"));
        $("#currentAddress").setValue("At 155 Country Lane, Cottington, Cottingshire County, UK");
        $("#react-select-3-input").setValue("Haryana");
        $("#react-select-3-input").pressEnter();
        $("#react-select-4-input").setValue("Panipat");
        $("#react-select-4-input").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Arthur"));
        $(".modal-content").shouldHave(text("Dent"));
        $(".modal-content").shouldHave(text("the_hitchhikers_guide@galaxy.com"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("4242424242"));
        $(".modal-content").shouldHave(text("12 October,1979"));
        $(".modal-content").shouldHave(text("Civics, History"));
        $(".modal-content").shouldHave(text("Reading, Music"));
        $(".modal-content").shouldHave(text("Civics, History"));
        $(".modal-content").shouldHave(text("floppa.png"));
        $(".modal-content").shouldHave(text("At 155 Country Lane, Cottington, Cottingshire County, UK"));
        $(".modal-content").shouldHave(text("Haryana Panipat"));

    }
}

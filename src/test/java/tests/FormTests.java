package tests;

import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTests {

    @Test
    void successfulFormstTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Arthur");
        $("#lastName").setValue("Dent");
        $("#userEmail").setValue("the_hitchhikers_guide@galaxy.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("4242424242");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1979");
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Civic").pressEnter();
        $("#subjectsInput").setValue("History").pressEnter();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("floppa.png");
        $("#currentAddress").setValue("At 155 Country Lane, Cottington, Cottingshire County, UK");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Arthur"), text("Dent"), text("the_hitchhikers_guide@galaxy.com"),
                text("Male"), text("4242424242"), text("12 October,1979"), text("Civics, History"), text("Reading, Music"),
                text("Civics, History"), text("floppa.png"), text("At 155 Country Lane, Cottington, Cottingshire County, UK"),
                text("Haryana Panipat"));

    }
}

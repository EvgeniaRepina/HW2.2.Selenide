package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest2 {


    @Test
    void shouldBookingACard() throws InterruptedException {

        open("http://localhost:9999");
        $("[data-test-id='city']  input").setValue("Ба");

        SelenideElement popup = Selenide.element(".popup.input__popup");

        Assertions.assertTrue($(popup.shouldHave(Condition.text("Абакан"))).exists());
        Assertions.assertTrue($(popup.shouldHave(Condition.text("Барнаул"))).exists());
        Assertions.assertTrue($(popup.shouldHave(Condition.text("Биробиджан"))).exists());
        Assertions.assertTrue($(popup.shouldHave(Condition.text("Благовещенск"))).exists());
        Assertions.assertTrue($(popup.shouldHave(Condition.text("Хабаровск"))).exists());
        Assertions.assertTrue($(popup.shouldHave(Condition.text("Чебоксары"))).exists());


    }
}

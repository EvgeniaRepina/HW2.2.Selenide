package ru.netology.web;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class CardDeliveryTest {


    @Test
    void shouldBookingACard() throws InterruptedException {

        open("http://localhost:9999");
        $("[data-test-id='city']  input").setValue("Барнаул");
        String text = $("[formnovalidate][view]").getAttribute("value");

        $("[data-test-id='date']  input").setValue(text);
        $("[data-test-id='name']  input").setValue("Иванов Иван");
        $("[data-test-id='phone']  input").setValue("+79043847569");
        $("[data-test-id='agreement']").click();
        $(".grid-col button[role='button']").click();


        $(withText("Успешно!")).shouldBe(visible, Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible);
        $(byText("Встреча успешно забронирована на " + text)).exists();
    }
}

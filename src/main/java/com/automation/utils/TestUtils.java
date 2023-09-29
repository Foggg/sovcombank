package com.automation.utils;

import com.automation.application.Elements;
import io.appium.java_client.AppiumDriver;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Selenide.$;

public class TestUtils {

    public AppiumDriver driver;

    public int multiply(int a, int b) {

        /* This will not work due calculator display is Read Only
        $(Elements.display).setValue(a + "");
        $(Elements.button_multiply).click();
        $(Elements.display).setValue(b + "");
        */

        //Workaround just to test multiply with single digit numbers
        pushDigitButton(a);
        $(Elements.button_multiply).click();
        pushDigitButton(b);
        $(Elements.button_equals).click();

        return Integer.parseInt($(Elements.result).getText());
    }

    public float sqrt(int a) {
        $(Elements.button_sqrt).click();
        pushDigitButton(a);
        $(Elements.button_equals).click();
        String preResult = $(Elements.result).getText();
        return Float.parseFloat(preResult.replace(',', '.'));
    }

    public float divide(int a, int b) {
        pushDigitButton(a);
        $(Elements.button_divide).click();
        pushDigitButton(b);
        $(Elements.button_equals).click();
        if(b == 0){
            checkDividedByZeroMsg($(Elements.preview).getText());
            return 0;
        }
        String preResult = $(Elements.result).getText();
        return Float.parseFloat(preResult.replace(',', '.'));
    }

    static IntStream argsProvider() {
        return IntStream.range(0, 10);
    }

    private void pushDigitButton(int number) {
        switch (number) {
            case 1 -> $(Elements.button_1).click();
            case 2 -> $(Elements.button_2).click();
            case 3 -> $(Elements.button_3).click();
            case 4 -> $(Elements.button_4).click();
            case 5 -> $(Elements.button_5).click();
            case 6 -> $(Elements.button_6).click();
            case 7 -> $(Elements.button_7).click();
            case 8 -> $(Elements.button_8).click();
            case 9 -> $(Elements.button_9).click();
            default -> $(Elements.button_0).click();
        }
    }

    private void checkDividedByZeroMsg(String msg){
        if(!msg.equals("На 0 делить нельзя")){
            throw new Error("Message is not correct");
        }
    }

}

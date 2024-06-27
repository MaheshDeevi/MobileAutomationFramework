package com.md.pages;

public final class HomePage extends BasePage {

 private HomePage(){}



    public static AppPage menuClick(String menu){
       click(menu);
       return new AppPage();
    }
}

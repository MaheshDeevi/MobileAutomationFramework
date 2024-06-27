package com.md.tests;

import com.md.annotations.FrameworkAnnotations;
import com.md.enums.CategoryType;
import com.md.pages.HomePage;
import org.testng.annotations.Test;

public class TapTest extends BaseTest{

    @FrameworkAnnotations(author= {"Mahesh","Harish"},category= {CategoryType.REGRESSION,CategoryType.SMOKE})
    @Test
    public void tapTest() {

       HomePage.menuClick("App")
               .appMenu("Activity");

    }

    @FrameworkAnnotations(author = {"Mahesh"},category = {CategoryType.REGRESSION})
    @Test
    public void swipeTest() {

        HomePage.menuClick("App")
                .appMenu("Activity");

    }
}

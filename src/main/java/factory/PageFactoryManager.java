package factory;

import pages.project01.HomePage;

public class PageFactoryManager {

    private static HomePage homePage;

    public static HomePage getHomePage(){
        /**
         * Using Ternary Operator: Checking for HomePO as null.
         *
         * If it is null, then, create new object and return
         *
         * If it is not null, then, return homePO
         */
        return homePage == null ? new HomePage() : homePage;
    }
}

package factory;

import pages.project01.HomePO;

public class PageFactoryManager {

    private static HomePO homePO;

    public static HomePO getHomePO(){
        /**
         * Using Ternary Operator: Checking for HomePO as null.
         *
         * If it is null, then, create new object and return
         *
         * If it is not null, then, return homePO
         */
        return homePO == null ? new HomePO() : homePO;
    }
}

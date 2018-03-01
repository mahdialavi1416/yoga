package com.technologygroup.rayannoor.yoga.Classes;

/**
 * Created by EHSAN on 3/1/2018.
 */

public class ClassLevels {

    public String getCoachLevelName(int idLevel){

        String levelName;

        switch (idLevel) {
            case -1:
                levelName = "بدون سطح";
                break;
            case 1:
                levelName = "سطح یک";
                break;
            case 2:
                levelName = "سطح دو";
                break;
            default:
                levelName = "بدون سطح";
        }

        return levelName;
    }

}

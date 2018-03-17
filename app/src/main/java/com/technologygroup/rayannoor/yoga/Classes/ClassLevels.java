package com.technologygroup.rayannoor.yoga.Classes;

/**
 * Created by EHSAN on 3/1/2018.
 */

public class ClassLevels {

    public String getCoachLevelName(int idLevel){

        String levelName;

        switch (idLevel) {
            case -1:
                levelName = "بدون طرح";
                break;
            case 1:
                levelName = "طرح یک ستاره";
                break;
            case 2:
                levelName = "طرح دو ستاره";
                break;
            default:
                levelName = "بدون طرح";
        }

        return levelName;
    }

}

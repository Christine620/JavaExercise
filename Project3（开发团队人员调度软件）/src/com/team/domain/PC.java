package com.team.domain;/**
 * ClassName:    PC
 * Package:    com.team.domain
 * Description:
 * Datetime:    2020/10/9   10:44
 * Author:   XXXXX@XX.com
 */

/**
 *   ClassName:    PC
 *   Package:    com.team.domain
 *   Description:
 *   Datetime:    2020/10/9   10:44
 *   Author:   XXXXX@XX.com
 */
public class PC implements Equipment{

    private String model;
    private String display;

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model+"("+display+")";
    }

}

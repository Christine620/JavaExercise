package com.team.domain;/**
 * ClassName:    Printer
 * Package:    com.team.domain
 * Description:
 * Datetime:    2020/10/9   10:45
 * Author:   XXXXX@XX.com
 */

/**
 *   ClassName:    Printer
 *   Package:    com.team.domain
 *   Description:
 *   Datetime:    2020/10/9   10:45
 *   Author:   XXXXX@XX.com
 */
public class Printer implements Equipment {
    private String name;
    private String type;

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name+"("+type+")";
    }
}
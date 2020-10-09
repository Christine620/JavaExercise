package com.team.service;/**
 * ClassName:    Status
 * Package:    com.team.service
 * Description:
 * Datetime:    2020/10/9   10:59
 * Author:   XXXXX@XX.com
 */

import java.lang.ref.PhantomReference;

/**
 *   ClassName:    Status
 *   Package:    com.team.service
 *   Description: 表示员工状态
 *   Datetime:    2020/10/9   10:59
 *   Author:   XXXXX@XX.com
 */
public class Status {
    private final String name;
    private Status(String name){this.name = name;}

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VACATION = new Status("VACATION");

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

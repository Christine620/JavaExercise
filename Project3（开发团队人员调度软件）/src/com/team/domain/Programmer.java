package com.team.domain;/**
 * ClassName:    Programmer
 * Package:    com.team.domain
 * Description:
 * Datetime:    2020/10/9   10:56
 * Author:   XXXXX@XX.com
 */

import com.team.service.Status;

/**
 *   ClassName:    Programmer
 *   Package:    com.team.domain
 *   Description:
 *   Datetime:    2020/10/9   10:56
 *   Author:   XXXXX@XX.com
 */
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE; //枚举类
    private Equipment equipment;

    public Programmer(){}
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsForTeam(){
        return memberId+ "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" +getSalary() + "\t" + "程序员";
    }
}

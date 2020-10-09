package com.team.service;/**
 * ClassName:    NameListService
 * Package:    com.team.service
 * Description:
 * Datetime:    2020/10/9   11:31
 * Author:   XXXXX@XX.com
 */

import com.team.domain.*;

import static com.team.service.Data.*;

/**
 *   ClassName:    NameListService
 *   Package:    com.team.service
 *   Description:负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 *   Datetime:    2020/10/9   11:31
 *   Author:   XXXXX@XX.com
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i=0;i<employees.length;i++){
            //获取员工类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bonus;
            int stock;

            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                    break;
            }
        }
    }

    /**
     *
     * @param index
     * @return:获取指定位置index上的员工设备
     */
    private Equipment createEquipment(int index){
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String modelOrName = EQUIPMENTS[index][1];
        switch (key){
            case PC:
                String display = EQUIPMENTS[index][2];
                return new PC(modelOrName,display);
            case NOTEBOOK:
                Double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(modelOrName,price);
            case PRINTER:
                String type = EQUIPMENTS[index][2];
                return new Printer(modelOrName,type);
        }
        return null;
    }

    /**
     *
     * @return:获取当前所有员工
     */
    public Employee[] getAllEmployees(){
        return employees;
    }

    /**
     *
     * @param id
     * @return 返回指定id的员工
     * @throws TeamException
     */
    public Employee getEmployee(int id) throws TeamException {
        for(int i=0;i<employees.length;i++){
            if(employees[i].getId()==id){
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工！");

    }


}

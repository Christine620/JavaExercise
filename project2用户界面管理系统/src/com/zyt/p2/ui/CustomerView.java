package com.zyt.p2.ui;

import com.zyt.p2.bean.Customer;
import com.zyt.p2.service.CustomerList;
import com.zyt.p2.utils.CMUtility;

import java.beans.Customizer;

/**
 * ClassName:    CustomerView
 * Package:    com.zuy.p2.ui
 * Description: CustomerView为主模块，负责菜单的显示和处理用户操作
 * Datetime:    2020/9/17   10:47
 * Author:   XXXXX@XX.com
 */
public class CustomerView {
   private CustomerList customerList = new CustomerList(10);
   public CustomerView(){
       Customer customer = new Customer("jade",'f',23,"18979349374","131kofdf@qq.com");
       customerList.addCustomer(customer);
   }

    /**
     * 显示《客户信息管理软件的界面》
     */
    public void enterMainMenu(){
        boolean ifFlag = true;
        while (ifFlag){
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    //System.out.println("退出");
                    System.out.println("是否确认退出？(Y/N)");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        ifFlag = false;
                    }
                    break;
            }
        }

    }

    /**
     * 添加用户
     */
    private void addNewCustomer(){
        //System.out.println("添加客户");
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名： ");
        String name = CMUtility.readString(10);
        System.out.print("性别： ");
        char gender = CMUtility.readChar();
        System.out.println("年龄：");
        int age = CMUtility.readInt();
        System.out.println("电话： ");
        String phone = CMUtility.readString(13);
        System.out.println("邮箱： ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("-------------------客户目录已满，添加失败---------------");
        }


    }

    /**
     * 修改用户
     */
    private void modifyCustomer(){
        //System.out.println("修改客户");
        System.out.println("---------------------修改客户---------------------");
        Customer customer;
        int number;
        for(;;){
            System.out.print("请选择待修改客户编号：(-1退出) ");
             number = CMUtility.readInt();
            if(number==-1){
                return;
            }
            customer = customerList.getCustomer(number-1);
            if(customer==null){
                System.out.println("无法找到指定客户！");
            }else {
                //找到客户
                break;
            }

        }
        //修改客户信息
        System.out.println("姓名("+customer.getName()+"):");
        String name = CMUtility.readString(10,customer.getName());
        System.out.println("性别("+customer.getGender()+"):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.println("年龄("+customer.getAge()+"):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.println("电话("+customer.getPhone()+"):");
        String phone = CMUtility.readString(13,customer.getPhone());
        System.out.println("邮箱("+customer.getEmail()+"):");
        String email = CMUtility.readString(20,customer.getEmail());
        Customer newCust = new Customer(name,gender,age,phone,email);
        boolean isReplaces = customerList.replaceCustomer(number-1,newCust);
        if(isReplaces){
            System.out.println("---------------------修改完成---------------------");
        }else {
            System.out.println("---------------------修改失败---------------------");
        }







    }

    /**
     * 删除用户
     */
    private void deleteCustomer(){
       // System.out.println("删除客户");
        System.out.println("---------------------删除客户---------------------");
        int number;
        Customer customer;
        for (;;){
           System.out.println("选择待删除客户的编号(-1退出): ");
            number = CMUtility.readInt();

           if(number==-1){
               return;
           }
           customer = customerList.getCustomer(number-1);
           if(customer==null){
               System.out.println("无法找到指定客户！");
           }else{
               break;
           }
       }

        //删除该用户
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete=='Y'){
            boolean isDel = customerList.deleteCustomer(number-1);
            if(isDel){
                System.out.println("---------------------删除完成---------------------");
            }else {
                System.out.println("---------------------删除失败---------------------");
            }
        }else {
            return;
        }


   }


    /**
     * 显示所有用户
     */
    private void listAllCustomers(){
        //System.out.println("显示所有用户");
        System.out.println("---------------------------客户列表---------------------------\n");
        //先判断有没有数据
        if(customerList.getTotal()==0){
            System.out.println("没有客户记录!");
        }else {
            System.out.println("编号\t姓名\t\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] allCustomers = customerList.getAllCustomers();
            for(int i=0;i<allCustomers.length;i++){
                System.out.println((i+1)+"\t"+allCustomers[i].getName()+"\t"+allCustomers[i].getGender()
                +"\t"+allCustomers[i].getAge()+"\t"+allCustomers[i].getPhone()+"\t"+allCustomers[i].getEmail());
            }

        }



        System.out.println("-------------------------客户列表完成-------------------------");

    }
    public static void main(String[] args){



        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();

    }


}

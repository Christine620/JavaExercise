package com.zyt.p2.ui;

import com.zyt.p2.bean.Customer;
import com.zyt.p2.service.CustomerList;
import com.zyt.p2.utils.CMUtility;

import java.beans.Customizer;

/**
 * ClassName:    CustomerView
 * Package:    com.zuy.p2.ui
 * Description: CustomerViewΪ��ģ�飬����˵�����ʾ�ʹ����û�����
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
     * ��ʾ���ͻ���Ϣ��������Ľ��桷
     */
    public void enterMainMenu(){
        boolean ifFlag = true;
        while (ifFlag){
            System.out.println("\n-----------------�ͻ���Ϣ�������-----------------\n");
            System.out.println("                   1 �� �� �� ��");
            System.out.println("                   2 �� �� �� ��");
            System.out.println("                   3 ɾ �� �� ��");
            System.out.println("                   4 �� �� �� ��");
            System.out.println("                   5 ��       ��\n");
            System.out.print("                   ��ѡ��(1-5)��");

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
                    //System.out.println("�˳�");
                    System.out.println("�Ƿ�ȷ���˳���(Y/N)");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit=='Y'){
                        ifFlag = false;
                    }
                    break;
            }
        }

    }

    /**
     * ����û�
     */
    private void addNewCustomer(){
        //System.out.println("��ӿͻ�");
        System.out.println("---------------------��ӿͻ�---------------------");
        System.out.print("������ ");
        String name = CMUtility.readString(10);
        System.out.print("�Ա� ");
        char gender = CMUtility.readChar();
        System.out.println("���䣺");
        int age = CMUtility.readInt();
        System.out.println("�绰�� ");
        String phone = CMUtility.readString(13);
        System.out.println("���䣺 ");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(customer);
        if(isSuccess){
            System.out.println("---------------------������---------------------");
        }else{
            System.out.println("-------------------�ͻ�Ŀ¼���������ʧ��---------------");
        }


    }

    /**
     * �޸��û�
     */
    private void modifyCustomer(){
        //System.out.println("�޸Ŀͻ�");
        System.out.println("---------------------�޸Ŀͻ�---------------------");
        Customer customer;
        int number;
        for(;;){
            System.out.print("��ѡ����޸Ŀͻ���ţ�(-1�˳�) ");
             number = CMUtility.readInt();
            if(number==-1){
                return;
            }
            customer = customerList.getCustomer(number-1);
            if(customer==null){
                System.out.println("�޷��ҵ�ָ���ͻ���");
            }else {
                //�ҵ��ͻ�
                break;
            }

        }
        //�޸Ŀͻ���Ϣ
        System.out.println("����("+customer.getName()+"):");
        String name = CMUtility.readString(10,customer.getName());
        System.out.println("�Ա�("+customer.getGender()+"):");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.println("����("+customer.getAge()+"):");
        int age = CMUtility.readInt(customer.getAge());
        System.out.println("�绰("+customer.getPhone()+"):");
        String phone = CMUtility.readString(13,customer.getPhone());
        System.out.println("����("+customer.getEmail()+"):");
        String email = CMUtility.readString(20,customer.getEmail());
        Customer newCust = new Customer(name,gender,age,phone,email);
        boolean isReplaces = customerList.replaceCustomer(number-1,newCust);
        if(isReplaces){
            System.out.println("---------------------�޸����---------------------");
        }else {
            System.out.println("---------------------�޸�ʧ��---------------------");
        }







    }

    /**
     * ɾ���û�
     */
    private void deleteCustomer(){
       // System.out.println("ɾ���ͻ�");
        System.out.println("---------------------ɾ���ͻ�---------------------");
        int number;
        Customer customer;
        for (;;){
           System.out.println("ѡ���ɾ���ͻ��ı��(-1�˳�): ");
            number = CMUtility.readInt();

           if(number==-1){
               return;
           }
           customer = customerList.getCustomer(number-1);
           if(customer==null){
               System.out.println("�޷��ҵ�ָ���ͻ���");
           }else{
               break;
           }
       }

        //ɾ�����û�
        System.out.print("ȷ���Ƿ�ɾ��(Y/N)��");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete=='Y'){
            boolean isDel = customerList.deleteCustomer(number-1);
            if(isDel){
                System.out.println("---------------------ɾ�����---------------------");
            }else {
                System.out.println("---------------------ɾ��ʧ��---------------------");
            }
        }else {
            return;
        }


   }


    /**
     * ��ʾ�����û�
     */
    private void listAllCustomers(){
        //System.out.println("��ʾ�����û�");
        System.out.println("---------------------------�ͻ��б�---------------------------\n");
        //���ж���û������
        if(customerList.getTotal()==0){
            System.out.println("û�пͻ���¼!");
        }else {
            System.out.println("���\t����\t\t�Ա�\t����\t�绰\t\t\t����");
            Customer[] allCustomers = customerList.getAllCustomers();
            for(int i=0;i<allCustomers.length;i++){
                System.out.println((i+1)+"\t"+allCustomers[i].getName()+"\t"+allCustomers[i].getGender()
                +"\t"+allCustomers[i].getAge()+"\t"+allCustomers[i].getPhone()+"\t"+allCustomers[i].getEmail());
            }

        }



        System.out.println("-------------------------�ͻ��б����-------------------------");

    }
    public static void main(String[] args){



        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();

    }


}

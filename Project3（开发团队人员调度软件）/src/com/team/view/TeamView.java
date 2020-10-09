package com.team.view;/**
 * ClassName:    TeamView
 * Package:    com.team.view
 * Description:
 * Datetime:    2020/10/9   17:15
 * Author:   XXXXX@XX.com
 */

import com.team.domain.Employee;
import com.team.domain.Programmer;
import com.team.service.NameListService;
import com.team.service.TeamException;
import com.team.service.TeamService;

/**
 *   ClassName:    TeamView
 *   Package:    com.team.view
 *   Description:
 *   Datetime:    2020/10/9   17:15
 *   Author:   XXXXX@XX.com
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService TeamSvc = new TeamService();

    public void enterMainMenu(){
        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag){
            if(menu != '1'){
                listAllEmployees();
            }

            System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            menu  = TSUtility.readMenuSelection();
            switch (menu){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    delateMember();
                     break;
                 case '4':
                     //System.out.println("退出");
                     System.out.println("是否确认退出(Y/N)");
                     char isExit = TSUtility.readConfirmSelection();
                     if(isExit == 'Y'){
                         loopFlag = false;
                     }
                     break;
            }
      }



    }

    /**
     * 显示所有员工信息
     */
    private void listAllEmployees(){
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees = listSvc.getAllEmployees();
        if(employees == null || employees.length==0){
            System.out.println("公司没有任何员工信息！");
        }else {
            System.out.println("ID\t姓名\t\t年龄\t\t工资\t\t职位\t\t状态\t\t奖金\t\t股票\t\t领用设备");
            for(int i=0;i<employees.length;i++){
                System.out.println(employees[i]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");

    }

    /**
     * 查看开发团队情况
     */
    private void getTeam(){
        System.out.println("--------------------团队成员列表---------------------\n");
        Programmer[] team = TeamSvc.getTeam();
        if(team==null || team.length == 0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
            for(int i=0; i<team.length;i++){
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("-----------------------------------------------------");
    }

    /**
     * 添加团队成员
     */
    private void addMember(){
        System.out.println("---------------------添加成员---------------------");
        System.out.print("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee emp = listSvc.getEmployee(id);
            TeamSvc.addMember(emp);
            System.out.println("添加成功！");

        }catch (TeamException e){
            System.out.println("添加失败，原因："+ e.getMessage());
        }finally {
            TSUtility.readReturn();
        }
    }

    /**
     * 删除团队成员
     */
    private void delateMember(){
        System.out.println("---------------------删除成员---------------------");
        System.out.println("请输入要删除的员工TID：");
        int memberId = TSUtility.readInt();
        System.out.println("是否确认删除(Y/N)");
        char isDel = TSUtility.readConfirmSelection();
        if(isDel=='N'){
            return;
        }
        try{
            TeamSvc.removeMember(memberId);
            System.out.println("删除成功！");
        }catch (TeamException e){
            System.out.println("删除失败，原因： "+e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView teamView = new TeamView();
        teamView.enterMainMenu();
    }
}

package com.team.service;/**
 * ClassName:    TeanService
 * Package:    com.team.service
 * Description:
 * Datetime:    2020/10/9   15:36
 * Author:   XXXXX@XX.com
 */

import com.team.domain.Architect;
import com.team.domain.Designer;
import com.team.domain.Employee;
import com.team.domain.Programmer;

/**
 *   ClassName:    TeanService
 *   Package:    com.team.service
 *   Description: 关于开发团队成员的管理：添加、删除等
 *   Datetime:    2020/10/9   15:36
 *   Author:   XXXXX@XX.com
 */
public class TeamService {
    private static int counter = 1;  //给memberID赋值时使用
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队成员

    private int total;//开发团队实际人数

    public TeamService() {
    }

    /**
     *
     * @return 获取开发团队中的所有成员
     */
    public Programmer[] getTeam(){
        Programmer[] team = new Programmer[total];
        for(int i=0; i<team.length;i++){
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将指定员工添加到团队成员中
     * 	失败信息包含以下几种：
     * 成员已满，无法添加
     * 该成员不是开发人员，无法添加
     * 该员工已在本开发团队中
     * 该员工已是某团队成员
     * 该员正在休假，无法添加
     * 团队中至多只能有一名架构师
     * 团队中至多只能有两名设计师
     * 团队中至多只能有三名程序员
     * @param e
     */
    public void addMember(Employee e)throws TeamException{
        if(total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if(isExist(e)){
            throw new TeamException("该员工已在本开发团队中");
        }
        Programmer p = (Programmer)e;
        if("BUSY".equals(((Programmer) e).getStatus().getName())){
            throw new TeamException("该员工已是某团队成员");
        }
        if("VACATION".equals(((Programmer) e).getStatus().getName())){
            throw new TeamException("该员正在休假，无法添加");
        }

        //获取team中已有成员中的架构师，设计师，程序员人数
        int numOfArch = 0, numOfDes = 0, numOfPro = 0;
        for(int i=0;i<total;i++){
            if(team[i] instanceof Architect){
                numOfArch++;
            }else if(team[i] instanceof Designer){
                numOfDes++;
            }else {
                numOfPro++;
            }
        }
        if(p instanceof Architect){
            if(numOfArch>=1){
                throw new TeamException("团队中至多只能有一名架构师");
            }
        }else if(p instanceof Designer){
            if(numOfDes>=2){
                throw  new TeamException("团队中至多只能有两名设计师");
            }
        }else {
            if(numOfPro>=3){
                throw  new TeamException("团队中至多只能有三名程序员");
            }
        }

        //将p(e)添加到现有的team中
        team[total] = p;
        total++;
        //p状态改变
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    /**
     *判断指定员工是否存在现有团队之中
     * @param e
     * @return
     */
    private boolean isExist(Employee e){
        for(int i=0;i<total;i++){
            if(team[i].getId()==e.getId()){
                return true;
            }

        }
        return false;
    }

    /**
     * 删除团队指定成员
     * @param MemberId
     */
    public void removeMember(int MemberId) throws TeamException{
        int i ;
        for(i=0;i<total;i++){
            if(team[i].getMemberId()==MemberId){
                team[i].setStatus(Status.FREE);
                break;

            }
        }
        if(i==total){
            throw new TeamException("找不打指定的memberId成员，删除失败");
        }

        for(int j=i+1;j<total;j++){
            team[j-1] = team[j];
        }
        team[total-1] = null;
        total--;

    }
}

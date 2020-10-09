package com.team.test;/**
 * ClassName:    NameListServiceTest
 * Package:    com.team.test
 * Description:
 * Datetime:    2020/10/9   14:40
 * Author:   XXXXX@XX.com
 */

import com.team.domain.Employee;
import com.team.service.NameListService;
import com.team.service.TeamException;
import org.junit.Test;

/**
 *   ClassName:    NameListServiceTest
 *   Package:    com.team.test
 *   Description:对NameListService的测试
 *   Datetime:    2020/10/9   14:40
 *   Author:   XXXXX@XX.com
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService nameListService = new NameListService();
        Employee[] employees = nameListService.getAllEmployees();
        for(int i=0;i<employees.length;i++){
            System.out.println(employees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 101;
        try{
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        }catch (TeamException e){
            System.out.println(e.getMessage());
        }
    }

}

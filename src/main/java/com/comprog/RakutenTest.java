package com.comprog;

/*

Employee         Manager
001              010
002              010
003              010
010              020
Report employees under a manager
020 - 010,001,002,003
010 - 001,002,003

 */

import java.util.*;



class ManagerEmployeeTuple {
    String currEmp;
    String manager;

    public ManagerEmployeeTuple(String currEmp, String manager) {
        this.currEmp = currEmp;
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerEmployeeTuple that = (ManagerEmployeeTuple) o;
        return Objects.equals(currEmp, that.currEmp) && Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currEmp, manager);
    }
}

public class RakutenTest {

    Map<ManagerEmployeeTuple, Set<ManagerEmployeeTuple>> map;

//    public List<String> getEmployeesByMangerId(String managerId ) {
//
//    }
//
//    public void populateEmployeeManager( Map<String,String> employeeMap ) {
//        employeeMap.entrySet().stream().forEach(entry -> {
//
//            //For first node
//            if(map.containsKey(new ManagerEmployeeTuple(entry.getValue()))) {
//                Set<ManagerEmployeeTuple> reportees = map.get(entry.getKey());
//
//                reportees.add(new ManagerEmployeeTuple(entry.getValue(), entry.getKey()));
//
//                //Find where all current manager is an employee
//
//            } else {
//
//            }
//
//        };
//    }

}

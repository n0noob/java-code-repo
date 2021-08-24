package com.comprog;

// Java program to find number of persons under every employee

import java.util.*;

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


public class RakutenTest2 {
    static Map<String, Set<String>> map = new HashMap<>();

    public static Set<String> getEmployeesByMangerId(String managerId) {
        return map.get(managerId);
    }

    public static void populateEmployeeManager(Map<String, String> employeeMap) {
        Map<String, List<String>> mngrEmpMap =
                new HashMap<>();

        for (Map.Entry<String, String> entry : employeeMap.entrySet()) {
            String emp = entry.getKey();
            String mngr = entry.getValue();
            if (!emp.equals(mngr)) {
                List<String> directReportList = mngrEmpMap.get(mngr);

                if (directReportList == null) {
                    directReportList = new ArrayList<String>();
                    mngrEmpMap.put(mngr, directReportList);
                }
                directReportList.add(emp);
            }
        }

        for (String mngr : employeeMap.keySet())
            populateEmployeeManagerUtil(mngr, mngrEmpMap);

        for (String emp : employeeMap.values())
            populateEmployeeManagerUtil(emp, mngrEmpMap);
    }

    private static Set<String> populateEmployeeManagerUtil(String mngr,
                                                           Map<String, List<String>> mngrEmpMap) {
        Set<String> indirectReportees = new HashSet<>();

        if (!mngrEmpMap.containsKey(mngr)) {
            map.put(mngr, new HashSet<>());
            return indirectReportees;
        } else if (map.containsKey(mngr)) {
            indirectReportees = map.get(mngr);
        } else {
            List<String> directReportEmpList = mngrEmpMap.get(mngr);
            indirectReportees.addAll(directReportEmpList);
            for (String directReportEmp : directReportEmpList) {
                indirectReportees.addAll(populateEmployeeManagerUtil(directReportEmp, mngrEmpMap));
            }

            map.put(mngr, indirectReportees);
        }
        return indirectReportees;
    }


    // Driver function
    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("001", "010");
        dataSet.put("002", "010");
        dataSet.put("003", "010");
        dataSet.put("010", "020");

        populateEmployeeManager(dataSet);

        System.out.println("Reportees of 020 : " + getEmployeesByMangerId("020"));
    }

}
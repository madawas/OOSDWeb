/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package centerallocation;

import java.util.ArrayList;
import java.util.Collections;
import slmo.registration.School;
import slmo.registration.Student;
import slmo.registration.dao.SchoolDA;
import slmo.registration.dao.StudentDA;

/**
 *
 * @author Danula
 */
public class CenterAllocation {
    ArrayList<ExamCenter> centerList;
    ArrayList<Student> studentList;
    ArrayList<School> schoolList;
    public CenterAllocation() {
    centerList = new ArrayList<ExamCenter>();
    studentList = StudentDA.getAllStudents("pvt");
    schoolList = SchoolDA.getAllSchools();
    }
    
    
    
    public void allocateCenters(){
        int count=0;
        int cmb1max=1000;
        for(int i=0;i<studentList.size();i++)
            if(studentList.get(i).getMedium().equals("TAMIL"))
                count++;
        ArrayList<Integer> schools = new ArrayList<Integer>();
        ArrayList<Student> temp;
        for(int i=0;i<schoolList.size();i++){
            boolean found=false;
            temp=schoolList.get(i).getStudentList();
            for(int j=0;j<temp.size();j++)
            {
                if(temp.get(j).getMedium().equals("TAMIL"))
                {
                    found=true;
                    break;
                }
            }
            if(found=true)
                schools.add(temp.size());
            else
                schools.add(0);
        }
        Collections.sort(schools);
        for(int i=0;i<schoolList.size();i++){
         //   if(schools)
        }
    }

}

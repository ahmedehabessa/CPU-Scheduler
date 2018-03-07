import java.util.Collections;
import java.util.Queue;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class FCFS {
     
    
    public FCFS(){
        
    }
    public static Vector stringtovector(String x){
     int flag = 0, j,i=0;
     Vector v = new Vector();
     char[] c = new char[x.length()];
     c=x.toCharArray();
     String temp=new String();
        
        while (i!=x.length()){
            
            j=0;
            while ((c[i+j]!='\n') &&( c[i+j]!=' ')){
                temp=temp+c[i+j];
                j++;
                flag=1;
                if((i+j)==x.length())
                    break;
            }
            if(flag==1){
            v.add(Integer.parseInt(temp));
            i=i+j;
            }
            else
                i++;
            flag=0;
            temp="";
    
        }
    
    return v;
    }
    
    Queue<Process> totoo(Queue<Process> q){
        Vector<Process> pv=new Vector<Process>();
        int i; int size=q.size();
        for( i=0;i<size;i++)
            pv.add(q.poll());
        Collections.sort(pv);
        for(int j=0;j<size;j++)
            q.add(pv.elementAt(j));
        
        
    return q;
    }
    
}

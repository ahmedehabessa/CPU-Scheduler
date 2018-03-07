
import static java.lang.Math.abs;
import java.util.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class Process implements Comparable<Process> {
    private String name;
   private  int burst; 
   private  int arival;   
   private   int prio;
   private  int quantum;
   private  boolean arived;
   private boolean drawen;
   private int wait ;
   private int turnaround;
   public  Process(){
       burst =0;
       arival =0;
       prio=0;
       quantum =0;
       name="";
       wait =0;
       turnaround=0;
   }
   public Process(String n,int a,int b,int c,int d){
       burst =a;
       arival =b;
       prio =c;
       quantum =d;
       name=n;
       wait =0;
       turnaround=0;
   }
   public  void setarival(int x){
      arival = x;
      
   }
   public  void setburst(int a){
       burst=a;
   }
   public  void setprio(int a){
        prio=a;
   }
   public  void setquantum(int a){
        quantum=a;
   }
   public   int getarival(){
       return arival;
       
   }
   public  int getburst(){
       return burst;
       
   }
  
   public   int getprio(){
       return prio;
       
   }
   public   int getquantum(){
       return quantum;
       
   }
   public String getname(){
       return name;
   }
   public void setarived(boolean a){
       arived=a;
   }
   public boolean getarived(){
       return arived;
   }
   public void setdrawen(boolean a){
       drawen=a;
   }
   public boolean getdrawen(){
       return drawen;
   }
   /*public void addwait(int d){
       wait=0;
   }*/
    public int getwait(){
       return turnaround-burst;
   }
    public int getturaround2(){
        return turnaround;
    }
   public void addturaround (int d){
       turnaround=d-arival;
   }
public int getturnaround(){
    return turnaround;
}   
   public Process[] SJFNON(Process[] pp){
       
       
       for(int p=0;p<pp.length-1;p++){
           int maxindex=0;
           for(int j=1;j<pp.length-p;j++){
               if(pp[j].getburst()>pp[maxindex].getburst()){
                   maxindex=j;
               }
           }
               Process temp=new Process();
               temp = pp[pp.length-1-p];
               pp[pp.length-1-p]=pp[maxindex];
               pp[maxindex]=temp;
       }
       
       return pp;
   }
   
   public Process[] PIRONON(Process[] pp){
       for(int p=0;p<pp.length-1;p++){
           int maxindex=0;
           for(int j=1;j<pp.length-p;j++){
               if(pp[j].getprio()>pp[maxindex].getprio()){
                   maxindex=j;
               }
           }
               Process temp=new Process();
               temp = pp[pp.length-1-p];
               pp[pp.length-1-p]=pp[maxindex];
               pp[maxindex]=temp;
       }
      return pp; 
   }
   
   public Process[] SJFPRE(Process[] pp){
       
       Vector<Process> vp = new Vector<Process>();
        for(int p=0;p<pp.length-1;p++){
         int maxindex=0;
           for(int j=1;j<pp.length-p;j++){
               if(pp[j].getarival()>pp[maxindex].getarival() && pp[j].getburst()>pp[maxindex].getburst() ){
                   maxindex=j;
               }
               Process temp=new Process();
               temp = pp[pp.length-1-p];
               pp[pp.length-1-p]=pp[maxindex];
               pp[maxindex]=temp;
               
             }
        }
       
       return pp;
   }    
   public void printo(){
       System.out.printf("** burst %d  arival %d  prio %d  quantum %d   name %S  \n" ,burst,arival,prio,quantum ,name);
   }
  
    @Override
    public int compareTo(Process o) {
        return arival-o.getarival();
    }
    
    public Void SJFPNONREE(Vector pv,Vector arrival){
         Vector total=new Vector();
        Process bigtime = (Process) pv.lastElement();
        int next=0, nextarival=0;
        PriorityQueue<Process> q =new PriorityQueue<Process>(10,new Comparator<Process>(){
            public int compare(Process p1,Process p2){
                if(p1.getburst()<p2.getburst()) return -1;
                if(p1.getburst()>p2.getburst()) return 1;
                else return 0;
                 
            }
        });
        
        int time;
         for(time=0;time<bigtime.getarival();time=nextarival){
          //update nextarivalttime 
          if(next<pv.size()-1){
                                next++;    
                               
         
                     Process nexttime=(Process) pv.get(next);
                                nextarival=nexttime.getarival();
          } 
             for(int i=0;i<pv.size();i++){
                Process temp =(Process) pv.get(i); 
                if(temp.getarival()==time){
                    q.add(temp);
                
             }
          }
                Process headofq =new Process();
                headofq=q.poll();
                    int flag=0; int remanigtime=0;    
                if(headofq.getburst()==nextarival){
                          flag =1;                               
                     //   draw from time to time+burst
                  //      goto update nextarival
                  //delete
               }
                   else if(headofq.getburst()>nextarival){
                      //remain burst of process
                       int remainburst = headofq.getburst()-(nextarival-time);
                         //  drw starting form time to time+burst
                           //add remain to headofq
                     headofq.setburst(remainburst);
                     //add process to queue
                       q.add(headofq);
                       flag=1;
                 //goto updatenextarival
                  }
                   else{
                       
                    while (headofq.getburst()<nextarival){
                        //remain time to add another process
                          remanigtime = (time-headofq.getburst())-nextarival;
                               // draw start from time to time+burst
                               headofq.setburst(0);
                               flag=0;
                         //delete process from queue
                         headofq=q.poll();
                          }
                                                                                              
                       if(flag==0){
                                 nextarival=remanigtime;
                                  }
                       
                       }
         }
                                                                     
     //now we have prio q 
     //loop
     for(int i=0;i<=q.size();i++){ 
     //poll
     Process headofq= new Process();
         headofq =  q.poll();
       //gettimes
      
     int endtime = headofq.getburst()+time;
     
       headofq.setburst(0);
      //draw 
      //begin from time   to  endtime
      //update
      time=endtime;
     }
                                 
   return null;        
  }
   
}


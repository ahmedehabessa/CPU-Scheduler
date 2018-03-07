/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.lang.Math.abs;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class gui extends JFrame {
    private JLabel[] item1;
    
    
    public gui(String names,Vector a,Vector arival,Process[] pp, int box)
    {
        super("Schedulig algorithm assignment"); //title
        setLayout(new FlowLayout()); //default layout
       int temp=0 ,swap=0 ,j=0;
        JLabel[] item1 = new JLabel[5*a.size()];
        char[] c = new char[names.length()];
        c=names.toCharArray();
        String colect= new String();
        colect ="";
        //=========================================================
        if (box==1) /******************************FCFS*/
        {
            int currenttimefcfs=0;
        int enddrawfcfs=0; Vector<Process> pvfcfs=a;
        Collections.sort(pvfcfs);
            for(int i =0; i<a.size();i++){
                
             Process p=new Process();
             p=pvfcfs.get(i);
             
             enddrawfcfs=currenttimefcfs+p.getburst();
             item1[i] = new JLabel(currenttimefcfs+"..."+p.getname()+"..." +enddrawfcfs);
             item1[i].setForeground(Color.red);
             item1[i].setBackground(Color.white);
             item1[i].setOpaque(true);
              item1[i].setFont(new Font(item1[i].getFont().getName(), item1[i].getFont().getStyle(), 20));

             add(item1[i]); 
             p.addturaround(enddrawfcfs);
             currenttimefcfs=enddrawfcfs;
             j++;
             }
            float sum1=0,sum2=0;
             for(int i =0; i<a.size();i++)
             {
                 Process p2=pvfcfs.get(i);
                 sum1+=p2.getwait();
                 sum2 +=p2.getturnaround();
            }
             sum1=sum1/(pvfcfs.size());  sum2=sum2/(pvfcfs.size());
            String xxxxx = new String();  String xxx=new String();
            xxxxx=Float.toString(sum2);  xxx = Float.toString(sum1);
              item1[j] = new JLabel("avg waiting time="+ xxx + "     "+"avg turnaround time" + xxxxx);
            
              item1[j].setForeground(Color.white);
             item1[j].setBackground(Color.black);
             item1[j].setOpaque(true);
              item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
             add(item1[j]); 
        }
        //==============================================================================================
        /****************************************SJF NONPREEMPTIVE*************************************/
        else if (box==3){
            Collections.sort(arival);
            Vector<Process> pvector=arival;
            int currenttime=0,endofdraw=0;
            for(int i =0; i<a.size();i++){
             Process p=new Process();
             p=  (Process) arival.get(i);
             
                endofdraw=currenttime +p.getburst();
             item1[i] = new JLabel(currenttime+"..."+p.getname()+"..." +endofdraw);
             item1[i].setForeground(Color.red);
             item1[i].setBackground(Color.white);
             item1[i].setOpaque(true);
              item1[i].setFont(new Font(item1[i].getFont().getName(), item1[i].getFont().getStyle(), 20));
             add(item1[i]); 
             p.addturaround(endofdraw);
             currenttime=endofdraw;
             j++;
            }
            
            float sum1=0,sum2=0;
             for(int i =0; i<a.size();i++)
             {
                 Process p2=pvector.get(i);
                 sum1+=p2.getwait();
                 sum2 +=p2.getturnaround();
            }
             sum1=sum1/(pvector.size());  sum2=sum2/(pvector.size());
            String xxxxx = new String();  String xxx=new String();
            xxxxx=Float.toString(sum2);  xxx = Float.toString(sum1);
              item1[j] = new JLabel("avg waiting time="+ xxx + "     "+"avg turnaround time" + xxxxx);
            
              item1[j].setForeground(Color.white);
             item1[j].setBackground(Color.black);
             item1[j].setOpaque(true);
              item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
             add(item1[j]);
            
        }
        //===========================================================================================
        /****************************PRIO NONPREEMPTIVE**********************************************/
        else if (box==5){
            int endofdraw=0,currenttime=0;
            for(int i =0; i<a.size();i++){
             endofdraw= currenttime + pp[i].getburst();
            item1[i] = new JLabel(currenttime+"..."+pp[i].getname()+"..." +endofdraw);
            item1[i].setForeground(Color.red);
            item1[i].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[i].setOpaque(true);
             item1[i].setFont(new Font(item1[i].getFont().getName(), item1[i].getFont().getStyle(), 20));
            add(item1[i]); 
             pp[i].addturaround(endofdraw);
            currenttime=endofdraw;
            j++;
            }
             float sum1=0,sum2=0;
             for(int i =0; i<a.size();i++)
             {
                 sum1+=pp[i].getwait();
                 sum2 +=pp[i].getturnaround();
            }
             sum1=sum1/(a.size());  sum2=sum2/(a.size());
            String xxxxx = new String();  String xxx=new String();
            xxxxx=Float.toString(sum2);  xxx = Float.toString(sum1);
              item1[j] = new JLabel("avg waiting time="+ xxx + "     "+"avg turnaround time" + xxxxx);
            
              item1[j].setForeground(Color.white);
             item1[j].setBackground(Color.black);
             item1[j].setOpaque(true);
              item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
             add(item1[j]);       
        }
        //=============================================================================
        /************************************SHORTIST REMAINING JOP FIRST*************************************/
        else if (box==2){
        
        
         Vector pv=a;
         Vector<Process> waitingtimevector=new Vector<Process>();
                  
          Collections.sort(pv);
          Iterator it=pv.iterator();
          Iterator it1=pv.iterator();
          it1.next();
          
        //Process bigtime = (Process) pv.lastElement();
        int next=0, nextarival=0,endofdraw=0;
        PriorityQueue<Process> q =new PriorityQueue<Process>(10,new Comparator<Process>(){
            public int compare(Process p1,Process p2){
                if(p1.getburst()<p2.getburst()) return -1;
                if(p1.getburst()>p2.getburst()) return 1;
                else return 0;
                 
                
            }
        });
        int flg=0;
        int time=0,currenttime = 0;
        Process headofq =new Process(); int pollflag=0;
          
         while(it.hasNext()){ 
          Process iteratorprocess= (Process) it.next();
          q.add(iteratorprocess);
         
           
           
           if(it1.hasNext()){   
Process nextprocess=(Process) it1.next();               
             headofq=q.poll();
             endofdraw=nextprocess.getarival();
             
            item1[j] = new JLabel(currenttime+"..."+headofq.getname()+"..." +endofdraw);
            item1[j].setForeground(Color.red);
            item1[j].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[j].setOpaque(true);
             item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
            add(item1[j]);j++; 
            headofq.setburst(headofq.getburst()-(endofdraw-currenttime));
            if(headofq.getburst()<=0)
            headofq.addturaround(endofdraw);
             
            currenttime=endofdraw;
            if(headofq.getburst()>0)
            q.add(headofq);
           }
                         
         }
         Iterator tt=q.iterator();
    while(tt.hasNext()){ 
        
        headofq=q.poll();
  
             endofdraw+=headofq.getburst();
    
             
            item1[j] = new JLabel(currenttime+"..."+headofq.getname()+"..." +endofdraw);
            item1[j].setForeground(Color.red);
            item1[j].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[j].setOpaque(true);
            item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
            add(item1[j]);j++; 
            
            headofq.setburst(headofq.getburst()-(endofdraw-currenttime));
                headofq.addturaround(endofdraw);
            currenttime=endofdraw;
            
    }
    
    
    
             float sum1=0,sum2=0;
             for( int i =0; i<a.size();i++)
             {
                 Process p=(Process) pv.get(i);
                 sum2 +=p.getturnaround();
                 
                 sum1+=p.getturaround2()-(int)arival.get(i);
                 
            }
             sum1=sum1/(a.size());  sum2=sum2/(a.size());
            String xxxxx = new String();  String xxx=new String();
            xxxxx=Float.toString(sum2);  xxx = Float.toString(sum1);
              item1[j] = new JLabel("avg waiting time="+ xxx + "     "+"avg turnaround time" + xxxxx);
            
              item1[j].setForeground(Color.white);
             item1[j].setBackground(Color.black);
             item1[j].setOpaque(true);
             item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
             add(item1[j]);       
       
    
     }
                                 
          
  
             /////////////////////////////////////////////////////////////////////////
        /**********************************PRIO PREEMPTIVE***********************************/
            
        
        else if(box==4){
        Vector<Process> pv =a;
        Vector<Integer> burst =arival;
          
            
        Process bigtime = (Process) pv.lastElement();    
             int next=0, nextarival=0,endofdraw=0;
        
               Iterator it=pv.iterator();
               Iterator it1=pv.iterator();
               it1.next();
             
             PriorityQueue<Process> q =new PriorityQueue<Process>(10,new Comparator<Process>(){
            public int compare(Process p1,Process p2){
                if(p1.getprio()<p2.getprio()) return -1;
                if(p1.getprio()>p2.getprio()) return 1;
                else return 0;
                 
         }
        });
             int flg=0;
             int time=0,currenttime = 0;
             Process headofq =new Process(); int pollflag=0;
            
             
             
           while(it.hasNext()){ 
          Process iteratorprocess= (Process) it.next();
          q.add(iteratorprocess);
         
           
           
            if(it1.hasNext()){   
             Process nextprocess=(Process) it1.next();               
             headofq=q.poll();
             endofdraw=nextprocess.getarival();
             
            item1[j] = new JLabel(currenttime+"..."+headofq.getname()+"..." +endofdraw);
            item1[j].setForeground(Color.red);
            item1[j].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[j].setOpaque(true);
            item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
            add(item1[j]);j++; 
            headofq.setburst(headofq.getburst()-(endofdraw-currenttime));
            if(headofq.getburst()<=0)
            headofq.addturaround(endofdraw);
             
            currenttime=endofdraw;
            if(headofq.getburst()>0)
            q.add(headofq);
           }
                         
         }
         Iterator tt=q.iterator();
    while(tt.hasNext()){ 
        
        headofq=q.poll();
  
             endofdraw+=headofq.getburst();
    
             
            item1[j] = new JLabel(currenttime+"..."+headofq.getname()+"..." +endofdraw);
            item1[j].setForeground(Color.red);
            item1[j].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[j].setOpaque(true);
            item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
            add(item1[j]);j++; 
            
            headofq.setburst(headofq.getburst()-(endofdraw-currenttime));
                headofq.addturaround(endofdraw);
            currenttime=endofdraw;
            
    }
        
             float sum1=0,sum2=0;
             for( int i =0; i<a.size();i++)
             {
                 Process p=(Process) pv.get(i);
                 sum2 +=p.getturnaround();
                 
                 sum1+=p.getturaround2()-(int)arival.get(i);
                 
            }
             sum1=sum1/(a.size());  sum2=sum2/(a.size());
            String xxxxx = new String();  String xxx=new String();
            xxxxx=Float.toString(sum2);  xxx = Float.toString(sum1);
              item1[j] = new JLabel("avg waiting time="+ xxx + "     "+"avg turnaround time" + xxxxx);
            
              item1[j].setForeground(Color.white);
             item1[j].setBackground(Color.black);
             item1[j].setOpaque(true);
             item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
             add(item1[j]);       

          
             
             
    }
        /////////////////////////////////////////////////////////////////////////
        /*******************************ROUND ROBIN*******************************************/
        else if (box==6)
        {
          Vector<Process> pv =a;
          
            int quantum=pv.get(1).getquantum();
           
             int next=0, nextarival=0,endofdraw=0;
        
       
           
               PriorityQueue<Process> q =new PriorityQueue<Process>(10,new Comparator<Process>(){
            public int compare(Process p1,Process p2){
                if(p1.getarival()<p2.getarival()) return 1;
                if(p1.getarival()>p2.getarival()) return -1;
                else return 0;
                 
         }
        });
             
             int flg=0;
             int time=0,currenttime = 0;
             Process headofq =new Process(); int pollflag=0;
         
                Iterator it=pv.iterator();
               Iterator it1=pv.iterator();
               it1.next();
          
            
                       
           while(it.hasNext()){ 
          Process iteratorprocess= (Process) it.next();
          q.add(iteratorprocess);
         
                if(it1.hasNext()){   
                Process nextprocess=(Process) it1.next();               
                headofq=q.poll();
                //endofdraw=nextprocess.getarival();
                         
           if(headofq.getburst()>quantum)
             endofdraw=currenttime+quantum;
             else
              endofdraw=currenttime+headofq.getburst();
            
            item1[j] = new JLabel(currenttime+"..."+headofq.getname()+"..." +endofdraw);
            item1[j].setForeground(Color.red);
            item1[j].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[j].setOpaque(true);
            item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
            add(item1[j]);j++; 
            headofq.setburst(headofq.getburst()-(endofdraw-currenttime));
            if(headofq.getburst()<=0)
            headofq.addturaround(endofdraw);
             
            currenttime=endofdraw;
            if(headofq.getburst()>0)
            q.add(headofq);
           }
            
          
           }
           
            Queue<Process> qq=new LinkedList<Process>();
     
            Iterator pirq=q.iterator();
            while(pirq.hasNext())
            {
                qq.add((Process) pirq.next());
            }
         
            
            Iterator tt=qq.iterator();     
         while(tt.hasNext()){ 
        
            headofq=qq.poll();
             if(headofq.getburst()>quantum)
             endofdraw=currenttime+quantum;
             else
                 endofdraw=currenttime+headofq.getburst();
             
            item1[j] = new JLabel(currenttime+"..."+headofq.getname()+"..." +endofdraw);
            item1[j].setForeground(Color.red);
            item1[j].setBackground(Color.white);
            item1[j].setSize(100,0);
            item1[j].setOpaque(true);
            item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
            add(item1[j]);j++; 
           headofq.setburst(headofq.getburst()-(endofdraw-currenttime));
            if(headofq.getburst()<=0)
            headofq.addturaround(endofdraw);
             
            currenttime=endofdraw;
            if(headofq.getburst()>0)
            qq.add(headofq);
            
    }
               
        
         
             float sum1=0,sum2=0;
             for( int i =0; i<a.size();i++)
             {
                 Process p=(Process) pv.get(i);
                 sum2 +=p.getturnaround();
                 
                 sum1+=p.getturaround2()-(int)arival.get(i);
                 
            }
             sum1=sum1/(a.size());  sum2=sum2/(a.size());
            String xxxxx = new String();  String xxx=new String();
            xxxxx=Float.toString(sum2);  xxx = Float.toString(sum1);
              item1[j] = new JLabel("avg waiting time="+ xxx + "     "+"avg turnaround time" + xxxxx);
            
              item1[j].setForeground(Color.white);
             item1[j].setBackground(Color.black);
             item1[j].setOpaque(true);
             item1[j].setFont(new Font(item1[j].getFont().getName(), item1[j].getFont().getStyle(), 20));
             add(item1[j]);       

          
        }
      }
    }

    


       
     

                
                    
                    
                    
       


    
    
    
    


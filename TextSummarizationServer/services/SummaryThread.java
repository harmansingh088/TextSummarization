/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import pso.PSO;


/**
 *
 * @author dell1
 */
public class SummaryThread extends Thread {
    Socket skt=null;
    String un;
    Long size;
    public SummaryThread(Socket skt,String un,Long size){
    this.skt=skt;
    this.un=un;
    this.size=size;
}
    public void run()
    {
        DataInputStream dis=null;
        FileOutputStream fos=null;
        
        DataOutputStream dos=null;
        try
        {
            dis=new DataInputStream(skt.getInputStream());
            String filename=un+".txt";
            fos=new FileOutputStream(filename);
            byte[] b=new byte[4096];
            int c;
            for(int i=0;i<size;i+=b.length)
            {
                c=dis.read(b);
            
               
                fos.write(b,0,c);
            }
           
            PSO obj=new PSO(un);
            obj.summary();
            
            
            
            
            
            
            
            dos = new DataOutputStream(skt.getOutputStream());

           
            
            
            String myfile=un+"Summary.txt";
            FileInputStream fis = new FileInputStream(myfile);
            
            byte b1[] = new byte[1024];
            int d;
            while ((d = fis.read(b1)) != -1) {
                dos.write(b1, 0, d);
            }
            System.out.println("Data Sent Successfully from server to client");
            
            fis.close();
            
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in Run of Summary Thread:"+e);
        }
        finally
        {
            try
            {
                dis.close();
                fos.close();
                dos.close();
            }
            catch(Exception e)
            {
                System.out.println("Exception in finally of summary thread"+e);
            }
        }
    }

}

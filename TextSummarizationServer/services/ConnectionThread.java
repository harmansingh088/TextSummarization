/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeMap;

/**
 *
 * @author dell1
 */
public class ConnectionThread extends Thread {

    public static ServerSocket sskt = null;
    public Socket skt = null;
    TreeMap<String,Socket> tm = new TreeMap<String,Socket>();

    public void run() {
        try {
            sskt = new ServerSocket(1234);
            do {
                
                skt = sskt.accept();
                DataInputStream dis = new DataInputStream(skt.getInputStream());
                String un = dis.readUTF();
                tm.put(un,skt);
                Long size=dis.readLong();
                SummaryThread st=new SummaryThread(skt,un,size);
                st.start();

            } while (true);
        } catch (Exception e) {
            System.out.println("Exception in run:" + e);
        }

    }
}

package com.fredericboisguerin.insa.network.core.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMessageSenderService implements MessageSenderService {
    @Override
    public void sendMessageOn(String ipAddress, int port, String message) throws Exception {

        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            Socket clientSocket = new Socket(ipAddress, port);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            outToServer.writeBytes(message + '\n');
            clientSocket.close();
        }
        catch (IOException e){
            throw new UnsupportedOperationException();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Asus
 */
public class Message {
    public static enum Message_Type {Name, Disconnect,RivalConnected,Point, Selected, Finish,Start,}
    public Message_Type type;
    public Object content;
    public Message(Message_Type t)
    {
        this.type=t;
    }
}

package com.solvd.automation.classes.c15;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "message")
@XmlType(propOrder = { "host", "port","token" , "msg", "date" })
public class Message implements Comparable<Message>{
    private String id;
    private String userId;
    private String host;
    private int port;
    private String token;
    private String msg;
    private Date date;

    public Message() {

    }
    public Message(String id, String  msg, String userIdId){
        this.id = id;
        this.msg = msg;
        this.userId = userId;
        this.date = new Date();
    }
    public Message(String msg){
        this.msg = msg;
        this.date = new Date();
    }

    public Message(String id, String host, int port, String token, String msg, Date date){
        this.id = id;
        this.port = port;
        this.token = token;
        this.msg = msg;
        this.date = date;

    }
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public String getHost() {
        return host;
    }
    @XmlElement
    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }
    @XmlElement
    public void setPort(int port) {
        this.port = port;
    }

    public String getToken() {
        return token;
    }
    @XmlElement
    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }
    @XmlElement
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message [" + host + " " + port + " "+" "+token+" "+msg + " " + date.toString() + "]";
    }
    @Override
    public int compareTo(Message o) {
        return getDate().compareTo(o.getDate());
    }
}

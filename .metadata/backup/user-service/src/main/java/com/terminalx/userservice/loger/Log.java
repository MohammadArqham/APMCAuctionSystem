package com.terminalx.userservice.loger;

public class Log {
    String service,pkg,cls;

    public Log() {
    }

    public Log(String service, String pkg, String cls) {
        this.service = service;
        this.pkg = pkg;
        this.cls = cls;
    }

    public String getService() {
        return service;
    }

    public String getPkg() {
        return pkg;
    }

    public String getCls() {
        return cls;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public void log(String msg){
        System.out.println(":::"+service+" >"+pkg+" >"+cls+" >"+msg);
    }

}

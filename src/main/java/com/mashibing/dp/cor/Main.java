package com.mashibing.dp.cor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String []args){
        Msg msg=new Msg();
        msg.setMsg("大家好:),<script>,欢迎访问mashibing，996");
        String r = msg.getMsg();

        FilterChain fc = new FilterChain();
        fc.add(new HTMLFilter()).add(new SensitiveFilter());

        FilterChain fc2 = new FilterChain();
        fc2.add(new FaceFilter()).add(new UrlFilter());
        fc.add(fc2);

        fc.doFilter(msg);
        System.out.println(msg);
    }

}

class Msg{
    String name;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{
    Boolean doFilter(Msg m);
}

class HTMLFilter implements Filter{
    @Override
    public Boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r=r.replace('<','[');
        r=r.replace('>',']');
        msg.setMsg(r);
        return true;

    }
}

class SensitiveFilter implements Filter{
    @Override
    public Boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r=r.replace("996","955");
        msg.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter{
    @Override
    public Boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r=r.replace(":)","^V^");
        msg.setMsg(r);
        return true;
    }
}

class UrlFilter implements Filter{
    @Override
    public Boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r=r.replace("mashibing","py");
        msg.setMsg(r);
       return true;
    }
}


class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    public FilterChain add(Filter f){
        filters.add(f);
        return this;
    }
    @Override
    public Boolean doFilter(Msg m){
        for (Filter f:filters){
            if (!f.doFilter(m)){
                return false;
            }
        }
        return true;
    }
}
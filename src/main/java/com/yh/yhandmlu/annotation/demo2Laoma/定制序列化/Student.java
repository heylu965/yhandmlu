package com.yh.yhandmlu.annotation.demo2Laoma.定制序列化;

import java.util.Date;

public class Student {

    @Label("姓名")
    String name;

    @Label("出生日期")
    @Format(pattern = "yyyy/MM/dd")
    Date born;

    @Label("分数")
    double score;

    public Student(){

    }

    public Student(String name,Date born,double score){
        super();
        this.name = name;
        this.born = born;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", born=" + born +
                ", score=" + score +
                '}';
    }
}

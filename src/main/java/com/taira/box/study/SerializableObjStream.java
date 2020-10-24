package com.taira.box.study;

import com.taira.box.domain.SerializablePerson;

import java.io.*;

public class SerializableObjStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeObj();
        //readObj();
        System.out.println("hello idea");
    }
    //对象序列化
    public static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("taira.object"));
        oos.writeObject(new SerializablePerson("taira",18,"shanghai"));
        oos.close();
    }
    //对象反序列化
    public static void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("taira.object"));
        SerializablePerson sp = (SerializablePerson)ois.readObject();
        System.out.println(sp.getName()+"="+sp.getAge()+"="+sp.getAddress());
        ois.close();
    }
}

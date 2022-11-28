package me.day16.exception.close.autocloseable;

public class MyFileInputStream implements AutoCloseable {

    public MyFileInputStream() {
    }

    public void read() {
        System.out.println("MyResource Read ...");
    }


    @Override
    public void close() throws Exception {
        System.out.println("MyResource Closed!");
    }
}

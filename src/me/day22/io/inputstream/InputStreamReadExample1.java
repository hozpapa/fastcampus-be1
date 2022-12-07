package me.day22.io.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReadExample1 {
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            final String path = InputStreamReadExample1.class.getResource("").getPath();
            inputStream = new FileInputStream(path + "input_eng.txt"); // 한국어 깨짐 (1 바이트씩 읽음)
//            InputStream inputStream = new FileInputStream(path + "input_eng.txt");
            int readByte;

            // 읽을 수 있는 마지막 바이트까지 루프를 돌며 한 바이트씩 읽음
            while ((readByte = inputStream.read()) != -1) {
                System.out.print((char) readByte);
            }
//            inputStream.close(); // 어떤 문제가 생길 수 있을까? (읽는 도중 문제가 생기면 inputStream 안 닫힐 수도 있음)
        } catch (FileNotFoundException e) {
            // 파일이 없을 경우 전략
            System.out.println(e.getMessage());
        } catch (IOException e) {
            // IO 문제가 생길 경우 전략
            System.out.println(e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

package me.day21.practice.practice01;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class StudentDao {
    private static StudentDao studentDao;
    private Map<String, Student> map = DataBase.getInstance().getTableList().get(0).getData();

    public static StudentDao getInstance() {
        if (studentDao == null) {
            studentDao = new StudentDao();
        }
        return studentDao;
    }


    /**
     * @Param: Student key 값
     * @return: select된 Student 반환
     * */
    public Student select(String key) {
        // TODO: select 함수 구현
        return null;
    }


    public Students select(Predicate<Student> condition) {
        Students students = new Students();
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (condition != null) {
                if (condition.test(student)) {
                    students.getStudents().add(student);
                }
            }
        }

        return students;
    }


    public Students select() {
        Students studentAll = new Students();
        for (Student student : map.values()) {
            studentAll.getStudents().add(student);
        }
        return studentAll;
    }


    /**
     * @Param: Student key 값, Student 객체 1명
     * @return: DB에 정상적으로 insert 된 객체 반환
     * @exception: 현재 DB에 있는 객체들과 중복된 키를 가질 수 없음
     * */
    public Student insert(String key, Student student) {
        // TODO: insert 함수 구현
        return null;
    }

    /**
     * @Param: Students 들의 key 값들, Students 객체 (Student 객체 여러명 담을 수 있음)
     * @return: Students 객체 중 DB에 정상적으로 insert 된 객체 수 반환
     * @exception: 현재 DB에 있는 객체들과 중복된 키를 가질 수 없음
     * */
    public int insert(List<String> keys, Students students) {
        // TODO: insert 함수 구현
        return 0;
    }

    public int update(Predicate<Student> condition, Column column, Object value) {
        int count = 0;
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (condition != null) {
                if (condition.test(student)) {
                    if (column != null && column.getColumnName() != null) {
                        if (column.getColumnName().equals("sId")) {
                            map.get(num).setsId((String) value);
                        } else if (column.getColumnName().equals("sPw")) {
                            map.get(num).setsPw((String) value);
                        } else if (column.getColumnName().equals("sName")) {
                            map.get(num).setsName((String) value);
                        } else if (column.getColumnName().equals("sAge")) {
                            map.get(num).setsAge((Integer) value);
                        } else if (column.getColumnName().equals("sGender")) {
                            map.get(num).setsGender((String) value);
                        } else if (column.getColumnName().equals("sMajor")) {
                            map.get(num).setsMajor((String) value);
                        } else {
                            continue;
                        }
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public int delete() {
        return delete(s -> true);
    }

    public int delete(Predicate<Student> condition) {
        int count = 0;
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String num = iterator.next();
            Student student = map.get(num);

            if (condition != null) {
                if (condition.test(student)) {
                    iterator.remove();
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * @Param: Student key 값
     * @return: 삭제된 Student 반환
     * */
    public Student delete(String key) {
        // TODO: delete 함수 구현
        return null;
    }

}
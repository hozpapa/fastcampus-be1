package me.day22.lambda.methodreference.constructor;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesExample {
    public static void main(String[] args) {
        // String (id) -> Member (member)
        Function<String, Member> function1 = Member :: new;
        Member member1 = function1.apply("a1234");
        System.out.println("member1 = " + member1);

        // String (name), String (id) -> Member (member)
        BiFunction<String, String, Member> function2 = Member :: new;
        Member member2 = function2.apply("a", "a1234");
        System.out.println("member2 = " + member2);
    }
}

class Member {
    private String name;
    private String id;

    public Member() {
    }

    public Member(String id) {
        this.id = id;
    }

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) && Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
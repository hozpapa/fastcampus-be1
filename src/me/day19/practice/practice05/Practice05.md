1. 하나의 인터페이스 InterfaceA가 있다고 가정하자.

    `**InterfaceA ia = new InterfaceA() (X)**`

   > 익명객체로 구현할 경우에는 가능 (+ 추상 클래스도 같이 재정의해야 함)



2. 하나의 추상 클래스 AbstractClass가 있다고 가정하자.

    `**AbstractClass a = new AbstractClass() (X)**`

    > 익명객체로 구현할 경우에는 가능 (+ 추상 클래스도 같이 재정의해야 함)



3. 부모클래스 A를 상속하고 있는 자식 클래스 B가 있다고 가정하자. (B is A)

    `**A a = new B() (O)**`

    > 자식 객체는 부모 객체 변수 안에 살 수 있음

4. 인터페이스 InterfaceA를 구현하고 있는 구현 클래스 ImplementClassB가 있다고 가정하자.

    `**InterfaceA ia = new ImplementClassB() (O)**`

    > 인터페이스를 구현하고 있는 인터페이스 구현 객체는 인터페이스 객체 변수에 살 수 있음

5. 클래스 B의 필드로 클래스 A를 포함하고 있다고 가정하자. (B has a A)

    `**A a = new B() (X)**`

    > 상속 관계가 아닌 다른 관계에서는 불가능함 (** 상속 관계가 다형성에 사용됨)
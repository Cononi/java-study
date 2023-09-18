# java17

## 목차
1. [텍스트 블록의 변화](#텍스트-블록의-변화)
2. [Switch 표현식](#Switch-표현식)
3. [Record 클래스 추가](#Record)
4. [Switch 표현식](#텍스트-블록의-변화)
5. [instanceof 변수 추가](#instanceof-변수-추가)
6. [DateTimeFormatter.ofPattern("B") 추가](#datetimeformatterofpatternb-추가)
7. [Stream.toList() 추가](#streamtolist-추가)

---

## 텍스트 블록의 변화

```java
String text = """
            {
              "name": "John Doe",
              "age": 45,
              "address": "Doe Street, 23, Java"
            }
            """;
```

<br/>
<br/>


## Switch 표현식

- break 문에 대해 누락, 가독성 문제로  처리 방식 변경

```java
switch (fruit) {
        case APPLE, PEAR -> System.out.println("Common fruit");
        case ORANGE, AVOCADO -> System.out.println("Exotic fruit");
        default -> System.out.println("Undefined fruit");
}
```

- 반환값이 필요할 때

```java
String text = switch (fruit) {
        case APPLE, PEAR -> "Common fruit";
        case ORANGE, AVOCADO -> "Exotic fruit";
        default -> "Undefined fruit";
};
```

- 하나 이상의 동작을 수행할 때 (yield - 함수의 리턴과 같은 형태)

```java
String text = switch (fruit) {
        case APPLE, PEAR -> {
            System.out.println("the given fruit was: " + fruit);
            yield "Common fruit"; // 예약어 사용
        }
        case ORANGE, AVOCADO -> "Exotic fruit";
        default -> "Undefined fruit";
 };
```

- 타입 지정 선언 ( 지정선언을 하면 메소드 반환을 통해 값을 받을 수 있다. )

```java
switch (value) {
    case String str -> {
        // value가 String 타입인 경우 이 블록이 실행됩니다.
        System.out.println("String: " + str);
    }
    case Integer num -> {
        // value가 Integer 타입인 경우 이 블록이 실행됩니다.
        System.out.println("Integer: " + num);
    }
    default -> {
        // 어떤 타입에도 해당하지 않는 경우 이 블록이 실행됩니다.
        System.out.println("Unknown type");
    }
}
```

<br/>
<br/>

---

## Record
(롬복의 여러 기능을 구현하고 있다. 롬복 버전에 종속성이 생기는걸 방지해줌)
Java 17에서 도입된 "record"는 데이터 클래스를 정의하기 위한 새로운 형태의 클래스이며, 레코드는 데이터를 저장하고 관리하기 위한 클래스를 간결하게 정의하고 생성하는 데 사용된다. 레코드는 주로 데이터를 표현하고 데이터의 불변성을 보장하기 위한 목적으로 사용된다.

#### 레코드의 장점

1. 불변성: 레코드의 필드는 final로 선언되어 변경할 수 없으므로 레코드 인스턴스는 불변입니다.
2. 간결성: 필드와 메서드의 정의를 간소화하므로 코드가 간결해집니다.
3. 자동 생성 메서드: `equals()`, `hashCode()`, `toString()` 메서드가 자동으로 생성되어 편리하게 사용할 수 있습니다.
4. 패턴 매칭 (Pattern Matching): 레코드는 패턴 매칭과 잘 어울리며, 스위치 문에서 패턴 매칭을 사용할 때 특히 유용합니다.

- 레코드 생성자를 명시적으로 제공하기

  - Java 17에서는 레코드의 생성자를 명시적으로 정의할 수 있게 되어서 이를 통해 필드 초기화 외에도 다른 로직을 추가할 수 있다.

  ```java
  public record Person(String name, int age) {
      public Person {
          if (age < 0) {
              throw new IllegalArgumentException("Age cannot be negative");
          }
      }
  }
  ```

- 레코드 컴파일러가 레코드의 메소드를 자동으로 생성

  - Java 17부터는 레코드에 대한 `equals()`, `hashCode()`, `toString()` 메소드를 명시적으로 작성하지 않아도 자동으로 생성된다.

  ```java
  public record Person(String name, int age) {}
  ```

  - 위의 코드에서 `equals()`, `hashCode()`, `toString()` 메소드가 자동으로 생성됩니다.

- 레코드에서 다중 상속 지원

  - Java 17에서는 인터페이스와 다중 상속이 가능한 레코드를 정의할 수 있게 되었습니다.

  ```java
  public interface Identifiable {
      long id();
  }
  
  public record Employee(String name, long id) implements Identifiable {}
  ```

<br/>
<br/>

---

## instanceof 변수 추가

Java 17에서 `instanceof` 연산자는 객체의 타입을 확인하고 해당 객체가 특정 클래스나 인터페이스의 인스턴스인지를 검사하는 데 사용되며, `instanceof`는 주로 객체의 타입을 확인하고 그에 따라 다른 동작을 수행하는 조건문에서 사용된다.

`obj` 객체가 `String` 클래스의 인스턴스인지를 확인하고 결과에 따라 다른 메시지를 출력한다.

```java
Object obj = "Hello, Java 17";

if (obj instanceof String) {
    System.out.println("obj is an instance of String");
} else {
    System.out.println("obj is not an instance of String");
}
```

- 객체의 실제 타입을 확인하고 해당 타입에 따라 적절한 동작을 수행할 때 활용.

<br/>
<br/>

## 컴팩트한 숫자 포맷 지원

- SHORT 포맷 스타일

```java
NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
System.out.println(fmt.format(1000));
System.out.println(fmt.format(100000));
System.out.println(fmt.format(1000000));


[Output]
1K
100K
1M
```

- LONG 포맷 스타일

```java
fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
System.out.println(fmt.format(1000));
System.out.println(fmt.format(100000));
System.out.println(fmt.format(1000000));


[Output]
1 thousand
100 thousand
1 million
```

<br/>
<br/>

## DateTimeFormatter.ofPattern("B") 추가

- "B" 패턴은 local에 따라 사용되는 달/월/연도 관련 정보를 반환합니다.
- 일반적으로 "B" 패턴은 달/월/연도 관련 정보를 표시하는 문자열을 생성합니다.

```java
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");
System.out.println(dtf.format(LocalTime.of(8, 0)));
System.out.println(dtf.format(LocalTime.of(13, 0)));
System.out.println(dtf.format(LocalTime.of(20, 0)));
System.out.println(dtf.format(LocalTime.of(23, 0)));
System.out.println(dtf.format(LocalTime.of(0, 0)));


[Output]
in the morning
in the afternoon
in the evening
at night
midnight
```

<br/>
<br/>

## Stream.toList() 추가

Java 17 이전의 버전에서는 `Stream` 인터페이스에 직접 `toList()` 메서드가 없었다. 대신, `Collectors.toList()`를 사용하여 스트림의 요소를 `List`로 수집하는 방법을 사용해야 했다.

그러나 Java 16에서는 `Stream` 인터페이스에 `toList()` 메서드가 도입되었으며, Java 17에서도 동일한 방법으로 사용할 수 있다.

```java
 public static void main(String[] args) {
        // 문자열로 이루어진 스트림 생성
        Stream<String> stringStream = Stream.of("Apple", "Banana", "Cherry", "Date");
        
        // Stream.toList()를 사용하여 스트림의 요소를 List로 수집
        List<String> list = stringStream.toList();
        
        // 수집된 List를 출력
        System.out.println(list);
 }
```




## Chapter 4 - Oct 2

- Deck not unique, mutable

- String not unique, immutable

- Integer not unique
- ArrayList not unique

constrains before the transition

## Chapter4 - Oct 4

final keyword on field, need to initialized in the constructor

```java
class Rank implements CardAttribute {
}
```

在CardAttribute 里面定义一个None 匿名类

## Chapter6 - Oct 23

Design Context in Class: theater
Program class aggregate the show interface which is implemented by Movie, Concert, etc.

`assert pTitle!=null;`
`assert!pTitle.isBlank();`

EnumMap to store the movie, use null object pattern on Show to avoid empty value in the map.

if we want to have an doubleMovie class we can make it an aggregate and delegate to the movie class
类似于一个包装类，它的方法和属性委托给了Movie类。利用delegation。

Composite class aggregate the Show **interface** and implements the Show interface,
so that it can contain many different shows.

Ways to create show object into the Composite class at run time
- Constructor
- Setter (add method)
- static factory

don't want to contain null in the aggregate.
Array.asList() returns a unmodifiable list.
check StringJoiner

## Chapter6 - Oct 25

We don't want the elements in the composite to be mutable

new requirement: add a introductory in the show

we can create a decoration class which wrap the show class / decorate the show class

if you have a aggregation object, consider the delegation to the aggregate object

```java
// introduceShow aggregates one show
public class introduceShow implements Show {

  // decoration attribute
  private String speaker;
  private int extraTime;
  // delegation attribute
  private Show aShow;

  public introduceShow(introduceShow show) {
    extraTime = show.extraTime;
    speaker = show.speaker;
    // this is a shallow copy.
    // we also want a polymophic copy
    aShow = show.show;
  }

  // delegation methods ...

  Show copy() {
    return new introduceShow(extraTime, speaker.show.copy());
  }
}
```

we can also decorate the multiple show

sequence diagram is a way to show the delegation call in

### How to copy the polymorphic type structure?

we want to copy show object

if we put the copy constructor in introduceShow class, we will create a shallow copy

We put the copy method in the show interface `Show copy()`

`return new Movie(this)` implemented in the movie class.

How do me implement the copy method in CompositeShow class?
- we can copy each show and put them into an array and return a new show by passing the array.

## chapter6 - Oct 30

we want to add a default show in the Program class

prototype pattern: the type of the object you want to create is not known at compile time

command pattern: `SetCommand implements Command`, which set a given show on a day

we want a command that execute on the target object, which is Program in this case

how to reference the information we need in the SetCommand class?

- we can pass the parameter to the execute() method -- not a good idea
- we can pass the patameter into the SetCommand constructor -- better
- use *non-static* factory method to create an anonymous command class

类似于一个command对象包装了target类里的方法
`createSetCommand` `createClearCommand`
需要在工厂匿名类里面使用Program.this.method()来调用外部类的方法


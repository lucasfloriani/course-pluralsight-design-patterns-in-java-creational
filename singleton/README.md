# Singleton

[Singleton Design](singleton.png)

- Guarantee one instance
- Easy to implement
- Solves a well defined problem
- Don't abuse it

## Concepts

- Only one instance created of the object
- Guarantees control of a resource (because have all the creation logic in one place)
- Lazily loaded (Because it creates the instance only when called the getInstance method)

### Examples in the language

- Runtime (environment)
- Logger
- Spring Beans
- Graphic Managers

## Responsible

- Responsible of creating itself and managin their lifecycle
- Static in nature (property of the instance is static)
- Needs to be thread safe
- Private instance
- Private constructor
- No parameters required for construction (if has parameters it needs to be a factory method, because it violates the rule of Singletons)

## Example

```java
Runtime singletonRuntime = Runtime.getRuntime();
singletonRuntime.gc();
System.out.println(singletonRuntime);

Runtime anotherInstance = Runtime.getRuntime();
System.out.println(anotherInstance);

if (singletonRuntime == anotherInstance) {
  System.out.println("They are the same instance");
}
```

## PitFalls

- Often overused
- Difficult to unit test
- If not careful, not thread-safe
- Sometimes confused for Factory (getInstance receiving parameters) (As soon it needs parameter, is not a Singleton anymore bu rather a Factory)
- java.util.Calendar is NOT a Singleton (Is a Prototype) (Uses getInstance but creates a new instance everytime)

## Contrast from other Patterns

| Singleton                        | Factory                              |
|----------------------------------|--------------------------------------|
| Returns same instance            | Returns various instances            |
| One constructor method - no args | Multiple constructors                |
| No Interface                     | Interface driven                     |
|                                  | Adaptable to environment more easily |

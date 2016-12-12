## SimplePool
Android library that implements basic pool logic. Consists of two classes with ThreadSafe/NotTreadSafe implementation. Implementation is hidden behind the interface.


## How to include in project
Library is distributed via jitpack.io

```gradle
// Add this lines into your roou build.gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

```gradle
// Add dependency to library in any target project module
dependencies {
    compile 'com.github.alexoro:simplepool:VERSION'
}
```


## Usage
```java
SimplePool<Object> pool = new SimplePoolBase<>(new ObjectFactory<Object>() {

    // required callback
    @Override
    public Object newObject() {
        return new Object();
    }

    // optional callback
    @Override
    public void reset(Object object) {
        super.reset(object);
    }

});

Object obj = pool.acquire();
pool.release(obj);
```

## Implementations
__SimplePoolBase__ - not thread safe implementation via ArrayList.
__SimplePoolThreadSafe__ - thread safe implementation via synchronized wrapping of _SimplePoolBase_.

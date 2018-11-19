# Knowledge

### Java

###### java.lang

```
StringBuffer : thread-safe, mutalbe.
StringBuilder : mutable, no synchronization.
```

```
ThreadLocal : provide thread-local variables. copy the value to thread-self, no share with other threads. Still in heap.
```

###### java.net

```
ServerSocket :  A server socket waits for requests to come in over the network.
Socket :        A socket is an endpoint for communication between two machines.
```

###### java.io java.nio

```
java.io : aim to stream, blocking during read/write.
          inputstream, fileReader, bufferedReader.
java.nio : aim to buffer, blocking during read/write, but no wait when data is not ready in buffer. A single thread to monitor multiple connections. 
          Paths, Files.
```

###### java.text

```
DateFormat, SimpleDateFormat : format date to readable string.
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z", Locale.ENGLISH);
String text = format.format(new Date());

NumberFormat : 
MessageFormat :
```


###### java.time java.time.Format

```
LocalDate LocalTime LocalDateTime : 
DateTimeFormatter DateTimeFormatterBuilder :
```

###### java.util

```
HashTabel : non-null object saves, synchronized, replaced by ConcurrentHashMap 
HashMap : null object allows, non-synchronized, not thread-safe
```

###### java.util.concurrent

```
Executor, ExecutorService, ThreadPoolExecutor, ScheduledThreadPoolExecutor, FockJoinPool : 
Future, FutureTask : 
```

---------------------------------------------------------------------------------------------
###### weak reference vs. soft reference

```
weak reference : flag the object that isn't strong enough to live within memory during GC.
WeakReference ref = new WeakReference(obj); //create a reference that points to obj.

soft reference : The system can decide the obj that only has be soft referenced to live or die based on the memory usage. the obj will be living is there is enough memory space; otherwise, it will be died. The sample for soft reference is cache objects.
SoftReference cache = new SoftReference(cacheMap);
```

###### deep clone and shallow clone

```
deep clone : the reference object will be clone to a new instance during the main object clone.
shallow clone: use the same reference object between new clone object with the protype object.
```
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
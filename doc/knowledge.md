# Knowledge

### Java

###### Keywords

```
volatile vs. synchronized vs. Lock : 
volatile : to keep the value being view by the other thread. The value will be flushed to main memory from local memory. It can not keep the atomicity in some case; but it can keep visibility.
synchronized : lock the object when trying to execute, can keep atomicity and visibility and sequence.
Lock : It doesn't lock the whole object. It allows access at the same time in some case. Normally tryLock(); then change it; then unLock(); Also the timeout can be set when tryLobk;
```

```
transient : it ignores the property to be serialized. the transient property will be ignored during serialized and deserialized.
```

###### Base

```
boolean, byte : 8
char, short : 16
int, float : 32
long, double : 64
```

```
default digital is double : double d = 123.4; double d = 123.4; double d = 123.4f; double d = 123.4d;
operators: a++ a-- ">" ++a --a +a -a ~ ! ">" * / % ">" + - ">" >> << >>> ">" < > <= >= instanceof ">" == != ">" & ">" ^ ">" | ">" && ">" || ">" ?: ">" = += -= *= /= %= &= ^= |= <<= >>= >>>=
```

###### java.lang

```
StringBuffer : thread-safe, mutable. default capability is 16. extend based on length * 2 + 2.
StringBuilder : mutable, no synchronization. default capability is 16. extend based on length * 2 + 2.
```

```
ThreadLocal : provide thread-local variables. copy the value to thread-self, no share with other threads. Still in heap.
```

```
Thread : 
thread.yield() : "can insert into current queue before current thread". allow the other thread to run firstly. go ahead please to the other threads with higher priority or same priority. 
thread.sleep() : "sleep, do nothing". the thread sleeps for some time. do nothing. 
thread.join() : "wait the thread to die". the thread will run after the joined thread is die.
thread.interrupt() : just set flag to the target thread. target thread would be handle the flag or not. 
					 Some interal method can handle it naturally. object.wait() and thread.sleep() can handle it immediately, then throw out InterruptedException response;
					 java.nio class can handle it also, but throw out ClosedByInterruptException response.
```

```
Object :
object.wait() : wait the current thread until get the notify() or notifyAll() of current thread.
object.notify() : notify the waitting thread to queue.
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
Vector : synchronized, array, capability is extended by 2n, or n+increment
ArrayList : no-sync, capability is extended by n+n/2.
Linkedlist : double-linked list. capability is extended by n+1
```

```
HashTable : non-null object saves, synchronized, replaced by ConcurrentHashMap, capability increases 2n + 1. 
HashMap : null object allows, non-synchronized, not thread-safe, capability increases 2n.
```

###### java.util.concurrent

```
Executor, ExecutorService, ThreadPoolExecutor, ScheduledThreadPoolExecutor, FockJoinPool : 
Future, FutureTask : 

Lock :

synchronized : 
```

---------------------------------------------------------------------------------------------
###### weak reference vs. soft reference

```
weak reference : flag the object that isn't strong enough to live within memory during GC. It would be cleared during GC. 
WeakReference ref = new WeakReference(obj); //create a reference that points to obj.

soft reference : The system can decide the obj that only has be soft referenced to live or die based on the memory usage. it would live when the memory is enough. the obj will be living is there is enough memory space; otherwise, it will be died. The sample for soft reference is cache objects.
SoftReference cache = new SoftReference(cacheMap);
```

###### deep clone and shallow clone

```
deep clone : the reference object will be clone to a new instance during the main object clone.
shallow clone: use the same reference object between new clone object with the protype object.
```
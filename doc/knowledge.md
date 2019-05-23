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
        short a = 1;
        a += 1; //true
        a = a + 1; //compile error, should be  a = (short)(a + 1);

        int i = Integer.MAX_VALUE;
        System.out.println(i);
        int j = i + 1;
        System.out.println(j);
        System.out.println("i + 1 < i : " + (j < i));

        double d = Double.NaN;
        double compare = 100d;
        System.out.println("i > j || i <= j : " + (d > compare || d <= compare));

        float f = Float.NaN;
        float comparef = 100f;
        System.out.println("i > j || i <= j : " + (f > comparef || f <= comparef));
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

NumberFormat : it is Not thread-safe. No Synchronization
	NumberFormat.getInstance().format(number) 				//format number
	NumberFormat.getCurrencyInstance().format(currency)		//format currency
	NumberFormat.getPercentInstance().format(percent)		//format percent
	
	number = NumberFormat.getInstance().parse(str)			//parse string to formated number

MessageFormat : no synchronization
	String pattern  = "this is message pattern, that can show {0, date} , {0, time}, {1, number, integer}, and message {2}";
	Object[] parameters = new Object[]{};
	String result = new MessageFormat(pattern, Locale.US).format(parameters);
```


###### java.time java.time.Format

```
LocalDate LocalTime LocalDateTime : immutable and thread-safe, non timezone, non locale
	LocalDate.now(); LocalDate.of(year,month,day); Localdate.parse("2010-01-01"); 
	LocalTime.now(); LocalTime.of(hour,minute,second, nanOfSecond); LocalTime.parse("01:01:01.123456");
	LocalDateTime.now(); LocalDateTime.of(...); LocalDateTime.parse("2010-01-01T01:01:00.123Z");

	LocalDateTime can tranform to LocalDate and LocalTime:
	LocalDateTime.toLocalDate(); LocalDateTime.toLocalTime();
	
ZonedDateTime: tranform time between the different time zone:
	ZonedDateTime.now(ZoneId.of("UTC"));			//get the current zoned time
	time.withZoneSameInstant(ZoneId.of("newZone"));	//tranform to the time in newZone

DateTimeFormatter DateTimeFormatterBuilder : formatter for parsing date-time object; Builder is to build up a formatter

ZonedDateTime time = ZonedDateTime.parse(datetimeString,
                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSVV", Locale.ENGLISH).withZone(ZoneOffset.UTC));
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
Executor,FockJoinPool, Future, FutureTask : 

ExecutorService: manage the Executor termination and track the progress (Future);

ScheduledExecutorService: execute periodically;

ThreadPoolExecutor: impl Executor and ExecutorService interface, to provide the threadPool executor. It can block the program to use the system resources unlimitly. Also it maintains some basic statistics.

* core pool size and max pool size: automatically adjust the pool size 


synchronized : 
lock the whole object, when make the change, then release it. so it's safe and visible for the other threads.

Lock :
no lock the whole object, using tryLock() can try to get the control about the object (the timeout setting can be set also), then unlock() to release the resources; ReadWriteLock can allow all readLock to execute in the same time without writeLock.

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


### Algorithms

###### Sorting

Quicksort > Insertsort > Selectsort > Popsort

```
Quicksort : using recursion. get a flag, then switch elements between left and right (object is the left is smaller than flag, the right is bigger than flag), then do it in the left elements and the right elements.
time complexity: O(nlog(n))
```

```
Insertsort : get an element (normally it's second), then find the correct place on the left arrays, then insert it; do it one by one.
time complexity: O(N*N)
copy complexity: O(N*N)
```

```
Selectsort : select the min element, then swap it with the first one, then do it for the next smaller...
time complexity : O(N*N)
swap complexity : O(N) ?
```

```
Popsort : compare the first element and next element, swap each other if the first is bigger, then do it bwteen the second and third...
time complexity : O(N*N)
swap complexity : O(N*N)
```


### tools

* GC tools : HPJMeter, GCViewer
* Memory tools: JConsole, VisualVM, JMap, JHat, Eclipse Mat
* Insight: JProbe, YourKit, JProfiler

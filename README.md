****Elite: Dangerous Star Map Android Client****

A client library for the Elite: Dangerous Star Map APIs.

I've found several Mac, Windows, and iOS tools leveraging the EDSM APIs, but nothing geared 
specifically to our Android developer friends, myself included.

My hope is that this easy to use library will help innovate more tools available on our Android 
devices.

You can check out the other Elite: Dangerous tools I've created for Android at 
[my github](https://www.github.com/stpatrck)

**Installation**

- Library is available through `jcenter`. For maven projects include the following in your build 
script...
```groovy
dependencies {
    implementation 'com.github.stpatrck:edsm:+'
}
```

**Usage**

- First, initialize the client class `EdsmClient.java` with your application context. It is highly 
recommended to do this when the `Application.onCreate()` method is invoked.

```java
public class MyApplication extends Application {
    
    public void onCreate() {
        super.onCreate();
        
        EdsmClient.init(MyApp.getInstance());
    }
}
```

- If you are running in debug mode the `Server` should be set to `Test` to avoid overloading the 
EDSM servers during development and testing. Since `EdsmClient` is a singleton, use 
`EdsmClient.getInstance()` to get the current instance of the client in order to set the server.

```java
public class MyApplication extends Application {
    
    public void onCreate() {
        super.onCreate();
        
        EdsmClient.init(MyApp.getInstance());
        
        // EdsmClient defaults to ServerTest, so explicitly set it to
        // production when not running debug builds.
        if (!BuildConfig.DEBUG)
            EdsmClient.getInstance().setServer(Server.Production);
            
    }
}
```

- Now is also a good time to configure logging...
```java
public class MyApplication extends Application {
    
    public void onCreate() {
        super.onCreate();
        
        EdsmClient.init(MyApp.getInstance());
        
        // EdsmClient defaults to ServerTest, so explicitly set it to
        // production when not running debug builds.
        if (!BuildConfig.DEBUG)
            EdsmClient.getInstance().setServer(Server.Production);
        else
            EdsmClient.getInstance().setLoggingEnabled(true);
        
    }
}
```

- And that's all! You can now call any of the `EdsmClient` APIs.

**Notes**

A few notes on usage:
- Most importantly, I am not in any way affiliated with Frontier Games or any of the Elite: 
Dangerous developers. This is a pet project of an avid fan of the games.
- The client is still under heavy development so some features may contain bugs (like any other 
software) and have room for improvement. Please create issues and/or pull requests and I will 
address them as time permits. 

**Special Thanks**

I would like to give a very special thank you to developers and contributors of the EDSM site. 
Without them this library and the vast wealth of data about the cosmos would not be available.  

# dev_AgentsRH7
Agents and Aglets Review on RHEL 7

### Java Agents Basics
In its essence, a Java agent is a regular Java class which follows a set of strict conventions. The agent class must implement a public static void premain(String agentArgs, Instrumentation inst) method which becomes an agent entry point (similar to the main method for regular Java applications).

Once the Java Virtual Machine (JVM) has initialized, each such premain(String agentArgs, Instrumentation inst) method of every agent will be called in the order the agents were specified on JVM start. When this initialization step is done, the real Java application main method will be called.

However, if the class does not implement public static void premain(String agentArgs, Instrumentation inst) method, the JVM will try to look up and invoke another, overloaded version, public static void premain(String agentArgs). Please notice that each premain method must return in order for the startup phase to proceed.

Last but not least, the Java agent class may also have a public static void agentmain(String agentArgs, Instrumentation inst) or public static void agentmain(String agentArgs) methods which are used when the agent is started after JVM startup.

It looks simple on the first glance but there is one more thing which Java agent implementation should provide as part of its packaging: manifest. Manifest files, usually located in the META-INF folder and named MANIFEST.MF, contain a various metadata related to package distribution.

#### Running Java Agents
`-javaagent:<path-to-jar>[-options]`<br/>

`java -javaagent:advanced-java-agents-0.0.1-SNAPSHOT.jar`<br/.

javac polling/*.java
timeout /t 2
rmic polling.PollFactoryImpl
timeout /t 2
start rmiregistry 2000
timeout /t 2
start java -Djava.security.policy=polling/policy.txt polling.PollServer 127.0.0.1:2000
timeout /t 2
java -Djava.security.policy=polling/policy.txt polling.PollClient 127.0.0.1:2000
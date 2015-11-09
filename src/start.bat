javac polling/*.java
timeout /t 5
rmic polling.PollFactoryImpl
timeout /t 5
start rmiregistry 2000
timeout /t 5
start java -Djava.security.policy=polling/policy.txt polling.PollServer 127.0.0.1:2000
timeout /t 5
java -Djava.security.policy=polling/policy.txt polling.PollClient 127.0.0.1:2000
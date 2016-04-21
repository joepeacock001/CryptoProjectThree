Initial Readme


To run:
1. in the terminal, navigate to a directory with EchoServer, EchoClient, the ssl certificate, and SampleApp.
2. Do javac EchoServer
3. Do java -Djavax.net.ssl.keyStore=mySrvKeystore -Djavax.net.ssl.keyStorePassword=1234567 EchoServer
3. In a new terminal window in the same directory, do javac SampleApp
4. do java SampleApp
# Clone the application

git clone https://github.com/shubham-v/message-queue.git



# To run the application, execute following command in terminal by replacing text in between <> -


cd message-queue

mvn clean install

cd target

java -jar -Dspring.profiles.active=dev -Dspring.rabbitmq.host=<host> -Dspring.datasource.username=root -Dspring.rabbitmq.port=<port> -Dspring.rabbitmq.virtual-host=<vhost> -Dspring.rabbitmq.username=<uname> -Dspring.rabbitmq.password=<pass> *.jar


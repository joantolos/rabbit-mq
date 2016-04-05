# Rabbit MQ POC

Simple POC using Rabbit MQ with Java

## About Rabbit MQ

See [Rabbit MQ website](https://www.rabbitmq.com/)

* Robust messaging for applications
* Easy to use
* Runs on all major operating systems
* Supports a huge number of developer platforms
* Open source and commercially supported

## Setting up Rabbit MQ on your local machine

1. Download [Rabbit MQ](https://www.rabbitmq.com/download.html) and create the environment variable **RABBITMQ_HOME** pointing to the folder. 

2. Start Rabbit MQ on localhost

	${RABBITMQ_HOME}/sbin/rabbitmq-server

    Rabbit MQ is now running on: (localhost:5672)

3. Creating the user and giving permissions:

	rabbitmqctl add_user user password
	rabbitmqctl set_user_tags user administrator
	rabbitmqctl set_permissions -p / user ".*" ".*" ".*"
	
4. Install the management tool:
[Rabbit MQ Management Web Tool](https://www.rabbitmq.com/management.html)

	rabbitmq-plugins enable rabbitmq_management

	http://localhost:15672/
	
	Now you can enter the tool and take a look to the Queues using the credentials created on the step before.
	
## Producing / Consuming

Execute the main method on the class **com.joantolos.rabbit.mq.producer.Producer**. It will create the queue named *my_messages* and add the message *Message on the queue from the Producer*. You can check the management tool on your browser to see the queue:

![my_messages queue](my_messages.png "my_messages queue")

## Work Queues

## Publish / Subscribe

## Routing

## Topics

## RPC
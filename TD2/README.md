Questions TD2 :

Reception:

    Which lines are responsible for receiving messages?
    --> Ce qui est dans le while, de "DatagramPacket" à "+ received);"
    On which port is the server listening?
    --> The server is listening on port 4445
    What is the maximum size of a received message?
    --> The server can receive messages of up to 256 bytes in length
    What does the server do when a message is received?
    --> When a message is received, the server does the following:
    1. It reads the received data from the inPacket and converts it to a String.
    2. It checks if the received message is "end" using received.equals("end"). If it is "end," it sets the running variable to false, which will terminate the loop and stop the server.
    3. If the received message is not "end," the server gets the sender's address and port from the inPacket, and then it sends the same data back to the sender as an acknowledgment. This is done by creating a new DatagramPacket called outPacket and using socket.send(outPacket) to send the data back to the sender. This behavior essentially echoes the received message back to the sender.
    

Sending:

    What are the lines responsible for sending messages?
    --> DatagramPacket outPacket = new DatagramPacket(buf, buf.length, senderAddress, senderPort);
    socket.send(outPacket);
    What is the content of the message sent?
    Where is the message sent? (which address and port)?
    --> The message is sent to the address and port stored in the senderAddress and senderPort variables. These values are obtained from the inPacket object, which contains the address and port of the sender of the received message.

Miscellaneous:

    What class represents an IP adress?
    --> InetAddress
    Under which conditions does the program terminates?
    --> When it receives a message that is equal to "end," it sets the running variable to false, and the loop stops. This effectively terminates the program.
    What are the blocking operations in this code?
    --> The blocking operation in this code is socket.receive(inPacket). The receive method of the DatagramSocket is a blocking operation, meaning it will wait until a datagram packet is received on the specified socket. The program will block at this line until data is received, or until an exception occurs (e.g., if there is an issue with the socket).


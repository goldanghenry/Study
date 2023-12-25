#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define BUFFER_SIZE 1024

void error_handling(char *message);

int main(int argc, char *argv[]) {
    // Check if the correct number of command-line arguments is provided
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <IP> <PORT>\n", argv[0]);
        exit(1);
    }

    int serv_sock, clnt_sock;
    struct sockaddr_in serv_addr, clnt_addr;
    socklen_t clnt_addr_size;

    char buffer[BUFFER_SIZE];

    // Create a socket
    serv_sock = socket(PF_INET, SOCK_STREAM, 0);
    if (serv_sock == -1)
        error_handling("socket() error");

    // Initialize server address structure
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = inet_addr(argv[1]);
    serv_addr.sin_port = htons(atoi(argv[2]));

    // Bind the socket to the specified IP and port
    if (bind(serv_sock, (struct sockaddr*)&serv_addr, sizeof(serv_addr)) == -1)
        error_handling("bind() error");

    // Listen for incoming connections
    if (listen(serv_sock, 5) == -1)
        error_handling("listen() error");

    // Accept a connection from a client
    clnt_addr_size = sizeof(clnt_addr);
    clnt_sock = accept(serv_sock, (struct sockaddr*)&clnt_addr, &clnt_addr_size);
    if (clnt_sock == -1)
        error_handling("accept() error");

    while (1) {
        // Receive a message from the client
        read(clnt_sock, buffer, sizeof(buffer));
        if (strcmp(buffer, "EXIT\n") == 0) {
            printf("Connection with the client is terminated.\n");
            break;
        }
        
        // Print the received message on the server's side
        printf("%s", buffer);

        // Send the received message back to the client
        write(clnt_sock, buffer, sizeof(buffer));
    }

    // Close the connection with the client and the server socket
    close(clnt_sock);
    close(serv_sock);

    return 0;
}

// Function to handle errors and exit the program
void error_handling(char *message) {
    perror(message);
    exit(1);
}

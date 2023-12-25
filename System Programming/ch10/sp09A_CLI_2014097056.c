#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <arpa/inet.h>

#define BUFFER_SIZE 1024

void error_handling(char *message);

int main(int argc, char *argv[]) {
    // Check if the correct number of command-line arguments is provided
    if (argc != 4) {
        fprintf(stderr, "Usage: %s <IP> <PORT> <NAME>\n", argv[0]);
        exit(1);
    }

    int sock;
    struct sockaddr_in serv_addr;
    char buffer[BUFFER_SIZE];

    // Create a socket
    sock = socket(PF_INET, SOCK_STREAM, 0);
    if (sock == -1)
        error_handling("socket() error");

    // Initialize server address structure
    memset(&serv_addr, 0, sizeof(serv_addr));
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = inet_addr(argv[1]);
    serv_addr.sin_port = htons(atoi(argv[2]));

    // Connect to the server
    if (connect(sock, (struct sockaddr*)&serv_addr, sizeof(serv_addr)) == -1)
        error_handling("connect() 오류");

    // Send the client's name to the server
    sprintf(buffer, "I am %s\n", argv[3]);
    write(sock, buffer, sizeof(buffer));

    while (1) {
        // Receive a message from the server
        read(sock, buffer, sizeof(buffer));
        if (strcmp(buffer, "EXIT\n") == 0) {
            printf("Connection with the server is terminated.\n");
            break;
        }

        // Print the received message from the server
        printf("%s", buffer);

        // Receive a message from the standard input and send it to the server
        fgets(buffer, sizeof(buffer), stdin);
        write(sock, buffer, sizeof(buffer));

        // Check if the client wants to exit
        if (strcmp(buffer, "EXIT\n") == 0) {
            break;
        }
    }

    // Close the client socket
    close(sock);

    return 0;
}

// Function to handle errors and exit the program
void error_handling(char *message) {
    perror(message);
    exit(1);
}

// 2014097056 심화컴퓨터 우성현 자료구조 3차시 과제 2번 문제
#define _CRT_SECURE_NO_WARNINGS
#define FALSE 0
#define TRUE 1
#include <stdio.h>
#include <string.h>

typedef struct {
	char name[100];
	int age;
	float salary;
} human_being;

void inputinfo(human_being* person, int n);
int humansEqual(human_being* person1, human_being* person2);

void main() {
	human_being person1, person2;

	inputinfo(&person1, 1);
	inputinfo(&person2, 2);
	
	if (humansEqual(&person1, &person2) == TRUE) printf("The two human beings are the same");
	else printf("The two human beings are not the same");
}

// 포인터로 받고 내용도 수정하고...
void inputinfo(human_being* person,int n) {
	printf("Input person%d\'s name, age, salary :\n", n);
	int x;
	float y;
	fgets(person->name,sizeof(person->name),stdin);
	scanf_s("%d",&x);
	person->age = x;
	scanf_s("%f", &y);
	person->salary = y;
	getchar();
}

int humansEqual(human_being *person1, human_being *person2) {
	if (strcmp(person1->name, person2->name))
		return FALSE;
	if (person1->age != person2->age)
		return FALSE;
	return TRUE;
}
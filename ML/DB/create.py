# sqlite3 : SQLite 데이터베이스 내장 라이브러리
# https://docs.python.org/ko/3/library/sqlite3.html
import sqlite3

con = sqlite3.connect('opentutorials.db')  # DB 접속 여러개 접속할 경우 구별
cur = con.cursor()                      # 커서 객체, 어디까지 읽었는지 가상의 커서.
title = input('title? ')                # title을 물어보는 입력 prompt
body = input('body? ')
view = input('view? ')
# 시간을 나타내는 부분은 DATE
# title, body, view는 튜블타입으로 앞에 ?(place holder, 위치 포인트)에 치환
result = cur.execute('INSERT INTO topics (title, body, created, view) VALUES(?,?,DATE(),?)', (title, body, view))
# 이 상태면 저장이 안된다. 커밋을 해주어야 한다.
# 커밋 하기전 오류가 있으면 rollback()_(되돌리기) 하면 된다. insert문이 취소가 된다.
con.commit()  # 영구적 반영, 반영하기.

result = cur.execute('SELECT * FROM topics WHERE id = ?', (cur.lastrowid,)) # 마지막 커서가 있는 row의 id ,가 없으면 x(튜플)
# 값을 읽어왔을 때, fetchall() 여러 건의 데이터를 가져올 때, 한 건은 fetchone()
rows = result.fetchone()
print(rows) 
con.close()   # close하지 않으면, 다른 프로세스가 작업하는데 제약 사향이 많음.



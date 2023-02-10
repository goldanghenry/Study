# DB에 저장된 title 목록 가져오기
import sqlite3
con = sqlite3.connect('opentutorials.db')
cur = con.cursor()
result = cur.execute('SELECT * FROM topics')
rows = result.fetchall()
for row in rows:
    print(f'{row[0]} : {row[1]} : {row[4]}')
con.close()

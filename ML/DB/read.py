import sqlite3
con = sqlite3.connect('opentutorials.db')
cur = con.cursor()
id = input('id? ')
result = cur.execute('SELECT * FROM topics WHERE id = ?',(id,))
row = result.fetchone()
print(row)
con.close()

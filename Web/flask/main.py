from flask import Flask, render_template
import random
import sqlite3

con = sqlite3.connect('opentutorials', check_same_thread=False)
cur = con.cursor()

app = Flask(__name__)

topics = [
    {"id":1, "title":"html5", "body":"html is ..."},
    {"id":2, "title":"css3", "body":"css is ..."}
]

@app.route("/") 
def index(): 
  sql = 'SELECT id, title FROM topics'
  result = cur.execute(sql)
  topics = result.fetchall()
  return render_template('welcome.html', topics=topics)

@app.route("/read/<int:id>")
def read(id):
  sql = 'SELECT id, title FROM topics'
  result = cur.execute(sql)
  topics = result.fetchall()
  
  sql = 'SELECT id, title, body FROM topics WHERE id = ?'
  result = cur.execute(sql, (id,))
  selected = result.fetchone()
  return render_template('read.html', topic=selected, topics=topics)

app.run()  
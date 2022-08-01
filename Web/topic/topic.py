import streamlit as st

st.write('# topics')

import sqlite3
con = sqlite3.connect('opentutorials.db')
cur = con.cursor()
result = cur.execute('SELECT * FROM topics')
rows = result.fetchall()
for row in rows:
    print(f'{row[0]} : {row[1]} : {row[4]}')


rows

# 사이드바에 꾸미기
st.sidebar.write('# Welcome')

# padas가 sql 쿼리를 날려서 출력하는 것
import pandas as pd
view = str(st.slider('view',0,200,10))   # 슬라이더 0~200 , 단위 10
topic_db = pd.read_sql('SELECT * FROM topics WHERE view > '+view, con)
topic_db
con.close()
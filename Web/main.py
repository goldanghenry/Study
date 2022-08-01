import streamlit as st

# 조회수
view = [100, 78, 4, 30]

st.write('# View List')
st.write('## row data ')

view

st.write('## bar chart')
st.bar_chart(view)

st.write('## line chart')
st.line_chart(view)
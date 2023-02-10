import requests  # requests 사용
from bs4 import BeautifulSoup  # bs4(beautifulsoup4) 사용

### 컴퓨터학부 공지사항 URL ###
url = "https://computer.knu.ac.kr/bbs/board.php?bo_table=sub5_1"

response = requests.get(url)  # requests.get: URL 요청에 대한 응답 받기
notice_page = response.text   # .text: 받은 요청에 대한 내용 표시(HTML 코드)

soup = BeautifulSoup(notice_page, 'html.parser')  # beautifulsoup: HTML 코드의 데이터를 parser로 정리

# <tr> 태그의 자식 태그인 <td class="td_subject">의 자식 태그인 <div class="bo_tit">의 
# 자식 태그 <a>에 해당하는 데이터를 모두 가져와서 list로 반환.
notice_hrefs = soup.select('tr td.td_subject div.bo_tit a')

for tag in notice_hrefs: # list에 들어있는 <a>태그 요소 하나씩 tag에 저장하고
    print(tag['href']) # 태그 안의 속성 href를 [ ]안에 넣어서 공지사항 링크 가져오기
import requests  # requests 사용

### 컴퓨터학부 공지사항 URL ###
url = "https://computer.knu.ac.kr/bbs/board.php?bo_table=sub5_1"

response = requests.get(url)  # requests.get: URL 요청에 대한 응답 받기
print(response)

notice_page = response.text   # .text: 받은 요청에 대한 내용 표시(HTML 코드)
print(notice_page) # HTML코드 출력
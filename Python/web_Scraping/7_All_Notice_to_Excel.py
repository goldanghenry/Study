import requests                # requests 사용
from bs4 import BeautifulSoup  # bs4(beautifulsoup4) 사용
from openpyxl import Workbook  # openpyxl 사용

# 마지막 페이지 찾기
mainUrl = "https://computer.knu.ac.kr/bbs/board.php?bo_table=sub5_1"
response = requests.get(mainUrl)
mainPage = response.text
soup = BeautifulSoup(mainPage, 'html.parser')
lastPagehref = soup.select_one("a.pg_end")
lastPageind = lastPagehref['href'].find('page=') + len('page=')
lastPage = int(lastPagehref['href'][lastPageind:])

# excel 생성: 쓰기 전용으로
wb =Workbook(write_only=True) 
# sheet 생성
ws = wb.create_sheet('CSE_Notice')

# excel 헤더 생성
ws.append(['공지사항', '카테고리', '작성자', '날짜', '링크주소'])
print('header complete')


# 컴퓨터학부 공지사항 URL: 1page~마지막 페이지(385)까지 URL 가져오기 
for i in range(1, int(lastPage) + 1):
    url = f"https://computer.knu.ac.kr/bbs/board.php?bo_table=sub5_1&page={i}"
    response = requests.get(url)  # requests.get: URL 요청에 대한 응답 받기
    notice_page = response.text   # .text: 받은 요청에 대한 내용 표시(HTML 코드)

    soup = BeautifulSoup(notice_page, 'html.parser')  # beautifulsoup: HTML 코드의 데이터를 parser로 정리
    tr_tags = soup.select('div.tbl_wrap table tbody tr') # .select: <tr> 태그에 해당하는 데이터를 모두 가져와서 list로 반환.
    for tr_tag in tr_tags:              # tr_tags의 list에서 요소 하나씩 tr_tag로 가져와서 
        td_tags = tr_tag.select('td')   # <tr> 태그 내부에 있는 <td> 태그를 가져와 list로 반환.
        print('-', end='')
        # td_tags[1]: 공지사항의 제목, 링크, 카테고리가 저장된 부분
        # 제목
        temp = td_tags[1].select_one('div.bo_tit a')
        notice_title = temp.get_text().strip()
        # 링크
        notice_link = temp['href']
        # 카테고리
        notice_cate = td_tags[1].select_one('a.bo_cate_link').get_text().strip()

        # td_tags[2]: 공지사항의 작성자가 저장된 부분
        # 작성자
        notice_writer = td_tags[2].get_text().strip()

        # td_tags[4]: 공지사항의 작성날짜가 저장된 부분
        # 작성날짜
        notice_date = td_tags[4].get_text().strip()

        # # row list로 데이터 저장 후, 데이터 행 추가
        row = [notice_title, notice_cate, notice_writer, notice_date, notice_link]
        ws.append(row)  

wb.save('경북대_컴퓨터학부_공지사항_ALL.xlsx') # 파일 저장
print('save complete')

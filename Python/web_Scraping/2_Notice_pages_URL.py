import requests 
from bs4 import BeautifulSoup

# 마지막 페이지 찾기
mainUrl = "https://computer.knu.ac.kr/bbs/board.php?bo_table=sub5_1"
response = requests.get(mainUrl)
mainPage = response.text
print('mainPage',mainPage)
soup = BeautifulSoup(mainPage, 'html.parser')
lastPagehref = soup.select_one("a.pg_end")
print('lastPagehref',lastPagehref)
lastPageind = lastPagehref['href'].find('page=') + len('page=')
print('lastPageind',lastPageind)
lastPage = lastPagehref['href'][lastPageind:]
print('lastPage',lastPage)


print('Last Page :: ' + lastPage)
print()


# 컴퓨터학부 공지사항 URL: 1page~마지막 페이지(385)까지 URL 가져오기
for i in range(1, int(lastPage) + 1):
    url = f"https://computer.knu.ac.kr/bbs/board.php?bo_table=sub5_1&page={i}"
    print(url)
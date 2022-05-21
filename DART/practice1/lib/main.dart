import 'package:flutter/material.dart';
import 'package:english_words/english_words.dart';

void main() {
  runApp(const MyApp());
}

// StatelessWidget 앱 자체를 위젯으로 만듦
// StatelessWidget은 변경불가능(immutable), 모든 속성 값이 fianl
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    // build는 다른 하위 위젯을 어떻게 표현할지 서술
    return  MaterialApp(
      title: 'Startup Name Generator',
      theme: ThemeData(
        appBarTheme: const AppBarTheme(
          backgroundColor: Colors.white,
          foregroundColor: Colors.black,
        ),
      ),
      home: const RandomWords(),
    );
  }
}

// StatefulWidget은 위젯의 수명동안 변경될 수 있는 상태를 유지. 2개 이상의 클래스 필요.
// 1) StatefullWidget
// 2) State 클래스의 인스턴스 생성.
class _RandomWordsState extends State<RandomWords> {
  // 생성된 단어쌍 저장. 스크롤에 따라 단어 쌍이 무한히 증가, 사용자가 하트 아이콘 스위치를 눌러 가장 좋아하는 단어 쌍 지정
  final _suggestions = <WordPair>[]; // 식별자 앞에 _를 붙이면 프라이빗이 적용
  final _saved = <WordPair>{}; // set list, doesn't allow duplicate entries
  final _biggerFont = const TextStyle(fontSize: 18.0);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Startup Name Generator'),
        actions: [
          IconButton(
            icon: const Icon(Icons.list),
            onPressed: _pushSaved,
            tooltip: 'Saved Suggestions',
          )
        ],
      ),
      body: ListView.builder(
        padding: const EdgeInsets.all(16.0),
        itemBuilder: /*1*/ (contexet, i) {
          // 홀수: 구분선, 짝수 : 단어
          if (i.isOdd) return const Divider(); /*2*/ // 구분선 위젯

          final index = i ~/ 2; /*3*/ //i를 2로 나눈 뒤 정수 결과 반환
          if (index >= _suggestions.length) {
            _suggestions.addAll(generateWordPairs().take(10)); // /*4*/
          }

          final alreadySaved = _saved.contains(_suggestions[index]);

          return ListTile(
            title: Text(
              _suggestions[index].asPascalCase,
              style: _biggerFont,
            ),
            trailing: Icon(
              // NEW from here ...
              alreadySaved ? Icons.favorite : Icons.favorite_border,
              color: alreadySaved ? Colors.red : null,
              semanticLabel: alreadySaved ? 'Remove from saved' : 'Save',
            ),
            onTap: () {
              setState(() {
                if (alreadySaved) {
                  _saved.remove(_suggestions[index]);
                } else {
                  _saved.add(_suggestions[index]);
                }
              });
            },
          );
        },
      ),
    );
  }

  void _pushSaved() {
    Navigator.of(context).push(
      // Add lines from here...
      MaterialPageRoute<void>(
        builder: (context) {
          final tiles = _saved.map(
            (pair) {
              return ListTile(
                title: Text(
                  pair.asPascalCase,
                  style: _biggerFont,
                ),
              );
            },
          );
          final divided = tiles.isNotEmpty
              ? ListTile.divideTiles(
                  context: context,
                  tiles: tiles,
                ).toList()
              : <Widget>[];

          return Scaffold(
            appBar: AppBar(
              title: const Text('Saved Suggestions'),
            ),
            body: ListView(children: divided),
          );
        },
      ), // ...to here.
    );
  }
}

class RandomWords extends StatefulWidget {
  const RandomWords({super.key});
  @override
  State<RandomWords> createState() => _RandomWordsState();
}
/* https://codelabs.developers.google.com/codelabs/first-flutter-app-pt2#3
1) itemBuilder 콜백은 단어 쌍이 제안될 때마다 호출되고 각각을 ListTile 행에 배치합니다.
   짝수 행인 경우 ListTile 행에 단어 쌍을 추가합니다. 홀수 행인 경우 시각적으로 각 항목을 구분하는
   Divider 위젯을 추가합니다. 작은 기기에서는 구분선을 보기 어려울 수 있습니다.
2) ListView의 각 행 앞에 1 픽셀 높이의 구분선 위젯을 추가하십시오.
3) i ~/ 2 표현식은 i를 2로 나눈 뒤 정수 결과를 반환합니다.
   예를 들어: 1, 2, 3, 4, 5는 0, 1, 1, 2, 2가 됩니다.
   이렇게 하면 구분선 위젯을 제외한 ListView에 있는 단어 쌍 수가 계산됩니다.
4) 가능한 단어 쌍을 모두 사용하고 나면, 10개를 더 생성하고 제안 목록에 추가합니다.  */

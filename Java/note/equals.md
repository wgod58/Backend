##  equals 與 == 的差別
1. ==
```
  測試物件參考時，唯有當兩個參考指向同一物件時，==運算子的結果才為true

  需要特別注意的是，在String中使用==，因為Java為節省記憶體，會在某一輪
  調區中維護唯一的String物件，所以如果在類別裡使用同一字串，Java只會建立一個唯一的字串而已
```

2. equals
```
  equals在類別為Java原先就存在時，是比較兩個物件是否為相同類型的類別後再比較其內容值是否相同

  如果自定類別沒有覆蓋Object的equals類別的話，就以Object的equals來比較，
  Object的equals的比較方式如同
```

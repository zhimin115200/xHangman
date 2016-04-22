# xHangman
Hangman游戏  遵循MVP结构，提供本地与网络获取数据

## 程序主线  
调度ui的ILoadWordView接口-->获得单词的GetWordPresenter(持有ILoadWordView和UseCase)  
-->对model封装的UseCase（持有一个线程池和一个ui线程的handler）-->RestApi和LocalApi（model层）

每一层的数据返回全部使用回调实现

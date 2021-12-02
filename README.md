# ComposeToDo
這個 Side Project 是使用 MVVM 這個架構去寫的，首先透過 Retrofit 的方法去將 JSONPlaceHolder 的資料給抓下來，抓下來之後將他存在手機的 Database 裡面。
存完之後再透過 Repository 這一層將資料從 Database 裡面取出來，最後再透過 ViewModel 的部分將資料傳到 UI 介面上，這邊還使用了 Dagger Hilt 去做依賴注入，最後 UI 的部分則是使用 JetpackCompose 實作。
<img src="https://github.com/Jordan0222/ComposeToDo/blob/master/app/src/main/res/drawable-v24/todo.png" width="500">
<img src="https://github.com/Jordan0222/ComposeToDo/blob/master/app/src/main/res/drawable-v24/composetodo.jpg" width="500" height="800">

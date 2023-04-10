<h1 >Проект автоматизации UI для сайта <a href="www.fitmost.ru/ ">fitmost.ru</a></h1>

## Содержание

* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#testops">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram и Slack с использованием бота</a>
* <a href="#video">Пример прогона теста в Selenoid</a>

<a id="tools"></a>
## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/IntelliJ_IDEA.png" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.png" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java_logo.png" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.png" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/JUnit5.png" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.png" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.png" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.png" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/AllureReports.png" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/AllureTestOps.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/logo/Jira.png" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.png" width="50"/></a>
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Slack.png" width="50"/></a>
</div>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк [Selenide](https://selenide.org/).
Запуск тестов можно осуществлять локально или с помощью [Selenoid](https://aerokube.com/selenoid/).
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами в <code>Telegram</code> и <code>Slack</code> после завершения прогона.

Allure-отчет включает в себя:
* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page Source;
* логи браузерной консоли;
* видео выполнения автотеста.

<a id="cases"></a>
## Реализованные проверки

### Автоматизированные проверки
:heavy_check_mark: Переход на главную страницу при клике на лого FITMOST

:heavy_check_mark: Выбор локации доставки

:heavy_check_mark: В заголовке главной страницы отображаются соответствующие разделы

:heavy_check_mark: Переход в дополнительные разделы

:heavy_check_mark: Переход на страницу 'Выберите пакет баллов' при клике на 'Купить абонемент'

### Ручные проверки
:heavy_check_mark: Абонементы. Цена

:heavy_check_mark: Направления. Вид и количество баллов


<a id="console"></a>
##  Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean web_test 
```

С помощью использования переменной `env` можно переключаться между локальным и удалённым запуском тестов с параметрами по умолчанию. (_`-Denv=remote` для удалённого запуска тестов, `-Denv=local` - для локального_).


### Удаленный запуск тестов

```
clean web_test 
  -DbrowserName=${BROWSER_NAME} 
  -DbrowserVersion=${BROWSER_VERSION} 
  -DbrowserSize=${BROWSER_SIZE} 
  -DremoteUrl=${REMOTE_URL}
```

> `${BROWSER_NAME}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
>
> `${BROWSER_VERSION}` - номер версии браузера (_по умолчанию - <code>100.0</code>_).
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1920x1080</code>_).
>
> `${REMOTE_URL}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a id="jenkins"></a>
## Запуск тестов в <a target="_blank" href="https://jenkins.autotests.cloud/job/017_Guzel_Uz_web_fitmost_tests/"> Jenkins </a>

> Сборка с параметрами позволяет перед запуском изменить параметры для сборки (путем выбора из списка или прямым указанием значения).

<p align="center">
<img src="images/screenshots/JenkinsJob.PNG"/>
</p>

<a id="allure"></a>
## Отчеты в <a target="_blank" href="https://jenkins.autotests.cloud/job/017_Guzel_Uz_web_fitmost_tests/12/allure/"> Allure report </a>

### Основное окно

<p align="center">
<img src="images/screenshots/AllureOverview.png">
</p>

### Тесты

<p align="center">
<img src="images/screenshots/AllureBehaviors.png">
</p>

### Графики

<p align="center">
<img src="images/screenshots/AllureGraphs.png">
</p>

<a id="testops"></a>
## Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/2151/test-cases?treeId=4159"> Allure TestOps </a>

### Доска
<p align="center">
<img src="images/screenshots/AllureTestOpsDashboard.PNG">
</p>

### Тест-кейсы
<p align="center">
<img src="images/screenshots/AllureTestCases.PNG">
</p>

### Пример мануального тест-кейса
<p align="center">
<img src="images/screenshots/AllureTestOpsManualTest.PNG">
</p>

### Пример запуска тест-кейсов
<p align="center">
<img src="images/screenshots/AllureTestOpsLaunches.PNG">
</p>


<a id="jira"></a>
## Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-663"> Jira </a>
<p align="center">
<img src="images/screenshots/Jira.PNG">
</p>

<a id="telegram"></a>
## Уведомления в Telegram с использованием бота

<p>
<img src="images/screenshots/TelegramBot.PNG">
</p>

<a id="slack"></a>
## Уведомления в Slack с использованием бота

<p>
<img src="images/screenshots/SlackBot.PNG">
</p>

<a id="video"></a>
## Пример прогона теста в Selenoid

> К каждому тесту в отчете прилагается видео
<p align="center">
  <img src="images/video/Video_test_rates.gif">
</p>
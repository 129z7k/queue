###Задача
Разработать основу обработчика очереди.

#####Обработчик должен:

* Запускаться по расписанию, которое задаётся в конфигурационном файле;
* Брать задачи из очереди, до тех пор пока они там есть;
* При получении задачи если не был вызван connect() выбросить IllegalStateException;
* Если задач в очереди нет - отключиться от очереди и запуститься через указанный в конфиге интервал времени;
* Логировать задачи взятые из очереди.

#####Дополнительные требования
* Использовать произвольную реализацию очереди без внешних зависимостей
* Наполнить очередь демонстрационными задачами


###Реализация

* Очередь реализована на базе ArrayDeque в классе QueueApplication.java;
* Разработан класс SchedulerGet метод GetTaskFromQueue() которого вызывается через время, указанное в файле настроек scheduler.properties;
* До очередного чтения задач из очереди должен быть вызван метод connect(), в противном случае будет выброшено исключение IllegalStateException;
* После прочтения задач вызывается метод queue.disconnect();
* Полученные задачи из очереди логируются в файл /log/app.log, а также в консоль. Для отключения вывода информации по полученным задачам в консоль необходимо раскомментировать параметр logging.pattern.console= в файле application.properties
* Для запуска приложения из консоли необходимо ввести java -jar queue-0.0.1-SNAPSHOT.jar 

###Артефакт

* Артефакт проекта размещен по адресу target\queue-0.0.1-SNAPSHOT.jar
* Запуск проекта осуществляется командой java -jar queue-0.0.1-SNAPSHOT.jar
  
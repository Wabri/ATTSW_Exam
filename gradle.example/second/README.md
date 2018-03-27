1.  Creare una cartella gradle.example/second
2.  Eseguire la build:
`gradle init --type java-application`
3.  Usare il wrapper per controllare la versione attualmente in uso dal progetto:
`./gradlew --version`
4.  Cambiare la versione del wrapper alla 2.0:
`./gradlew wrapper --gradle-version 2.0`
5.  Controllare se la versione del wrapper è stata cambiata:
`./gradlew --version`
6.  Fare l’upgrade alla 3.0 del wrapper usando le properties, modificando il campo distribuitionUrl:
`distributionUrl=https\://services.gradle.org/distributions/gradle-3.0-bin.zip`
7.  Controllare se la versione del wrapper è stata cambiata
8.  Modificare il build.gradle per impostare la versione del wrapper alla 4.6:
```
task  wrapper(type: Wrapper) {
	gradleVersion = '4.6'
}
```
9.  La versione non sarà modificata fintanto che non verrà eseguito il task wrapper, eseguire quindi la build:
`./gradlew wrapper`
10.  Controllare se la versione del wrapper è stata cambiata
11.  Impostare All come tipo di distribuzione da usare per il wrapper, aggiungere quindi il campo distributionType:
```
task   wrapper(type: Wrapper) {
	gradleVersion = '4.6'
	distributionType = Wrapper.DistributionType.ALL
}
```
12.  Eseguire la build del task wrapper per aggiornare la distribuzione usata dal wrapper
13.  Visualizzare lo stato attuale dei daemon attualmente in esecuzione:
`./gradlew --status`
14.  Eseguire il task test usando il daemon:
`./gradlew --daemon test`
(Notare che se viene rieseguita questa build il tempo di esecuzione risulta essere nullo)
15.  Eseguire lo stesso task precedente senza usare il daemon:
`./gradlew --no-daemon test`
(Notare che non usando il daemon il tempo di esecuzione non sarà nullo)
16.  Stoppare il daemon attivo attualmente usato:
`./gradlew --stop <PID>`

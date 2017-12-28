1. creare una cartella gradle.example/second
2. spostarsi nella cartella creata e aggiungere il wrapper di gradle con il comando:
`gradle wrapper`
questo comando genererà dei file, non escludere questi file dalla repository altrimenti sarà necessario tutte le volte che il progetto sarà clonato di eseguire nuovamente questo comando.
3. eseguire il comando per visualizzare la versione di gradle attualmente usata dal wrapper:
`./gradlew --version`
4. cambiare la versione del wrapper alla 2.0:
`./gradlew wrapper --gradle-version 2.0`
e controllare nuovamente la versione.
5. tornare nuovamente all'ultima versione:
`./gradlew wrapper`
6. specificare la versione gradle che deve usare il wrapper direttamente nel build.gradle:
```
task wrapper(type: Wrapper) {
    gradleVersion = '2.0'
}
```
eseguire il task wrapper:
`./gradlew wrapper`
controllare che la versione sia quella giusta:
`./gradlew --version`
ripristinare la versione 4.4.1
7. modificare la versione direttamente nel file gradle/wrapper/gradle-wrapper.properties nell'ultima linea ci dovrebbe essere:
`distributionUrl=https\://services.gradle.org/distributions/gradle-4.4.1-bin.zip`
modificarla con:
`distributionUrl=https\://services.gradle.org/distributions/gradle-2.0-bin.zip`
e controllare la versione (che dovrebbe risultare la 2.0, nonostante che sul build.gradle ci sia specificato che la versione da usare è la 4.4.1). eseguire nuovamente il task wrapper per tornare alla versione indicata nel file di build.

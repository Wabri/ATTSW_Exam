1. Creare una cartella gradle.example/third
2. Eseguire la build: `$ gradle init --type java-application`
3. Controllare e nel caso modificare il build.gradle per fare in modo di avere:
- il java plugin
- Come unica repository MavenCentral
- junit 4.12
4. Eseguire la build dependencies per scaricare le dipendenze
5. Assicurarsi che junit sia configurato per il testImplementation, com'è possibile notare dal comando precedente la configurazione testCompile è deprecata
6. Eseguire nuovamente la build dependencies, controllare se la dipendenza junit è stata associata alla configurazione testImplementation
7. Eseguire la build di test con continuous: `$ ./gradlew test --continuous`
8. Aggiungere il metodo helloWorldSendTest nella classe di test AppTest:
```
@Test 
    public void helloWorldSendTest () {
	    App classUnderTest = new App();
	    assertEquals("Hello world!", classUnderTest.getGreeting());
    }
```
Questo dovrà far fallire la build test avviata nel punto precedente.

9. Correggere il test modificando il metodo getGreeting() nella classe App:
```
    public String getGreeting() {
        return "Hello world!";
    }
```
A questo punto la build test avrà successo.

10. Stoppare la build test usando la combinazione ctrl+d
11. Eseguire la build di test con continuous sul metodo testAppHasAGreeting(): 
`$ ./gradlew test --continuous --tests AppTest.testAppHasAGreeting`
12. Modificare il metodo di test helloWorldSendTest:
```
    @Test 
    public void helloWorldSendTest () {
	    App classUnderTest = new App();
	    assertEquals("Greetings", classUnderTest.getGreeting());
    }
```
Ovviamente la build avrà successo dato che non stiamo modificando il metodo sotto test. Stoppare quindi la build usando ctrl+d.

13. Modificare il metodo getGreeting della classe App in modo da non far fallire la build:
`    $ ./gradlew test --continuous --tests \*Test`
14. Aggiungere il MANIFEST alla build.gradle:
```
    jar {
        manifest {
            attributes("Implementation-Title": "App","Implementation-Version":1.0,'Main-Class':'App')
        }
    }
```
15. Eseguire la build jar: ` $ ./gradlew jar`
16. Provare ad eseguire l'applicativo appena creato (che si troverà nella directory build/libs/):
        `$ java -jar build/libs/third.jar`
    Quello che dovrà comparire sarà la stringa di ritorno del metodo getGreeting().

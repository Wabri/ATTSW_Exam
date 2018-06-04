1.  Creare una repository su github e clonarla localmente:

![githubRepo.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/githubRepo.png)

2. Nella repository locale creare una cartella chiamata tutorial:

![localGithubRepo.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/localGithubRepo.png)

3. Spostarsi nella cartella appena creata e eseguire la build Gradle \texttt{init} per una applicazione java:
```
    $ gradle init --type java-application
```

![gradleInit.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/gradleInit.png)

4. Modificare il build.gradle sostituendolo con questa versione:
```
plugins {
    id 'java'
    id 'application'
    id 'eclipse'
}

mainClassName = 'App'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'junit:junit:4.12'
}

task  wrapper(type: Wrapper) {
    gradleVersion = '4.6'
    distributionType = Wrapper.DistributionType.ALL
}
```
Con questo setting del file build abbiamo impostato sia il plugin di eclipse sia la distribuzione del wrapper da usare.

5. Aggiornare quindi il wrapper con la build relativa:
```
    $ ./gradlew wrapper
```

6. Creare i meta dati di eclipse con la build omonima definita dal plugin stesso:
```
    $ ./gradlew eclipse
```

7. Possiamo ora importare la repository su Eclipse:

![addExistingLocalGitRepository.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/addExistingLocalGitRepository.png)

8. Importare poi il progetto creato:

![localRepositoryEclipse.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/localRepositoryEclipse.png)

9. Effettuare il login su [travis-ci.org](https://travis-ci.org) e aggiungere la repository Github creata:

![newTravis.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/newTravis.png)

 Attivare la repository:

![newTravis.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/spuntaTravis.png)

Andare nelle impostazioni della repository:

![newTravis.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/settingsTravis.png)
 
E indicare al server di eseguire la build solo nel caso in cui ci sia il travis.yml:

![newTravis.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/buildOnlyTravis.png)


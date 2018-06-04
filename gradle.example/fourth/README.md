1.  Creare una repository su github e clonarla localmente:
![githubRepo.png](../../relation/latex_source/4IntegrationWithOtherTool/tutorial/githubRepo.png)
2. Nella repository locale creare una cartella chiamata tutorial:
![localGithubRepo.png](localGithubRepo.png)
3. Spostarsi nella cartella appena creata e eseguire la build Gradle \texttt{init} per una applicazione java:
```
    $ gradle init --type java-application
```
![gradleInit.png](gradleInit.png)
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
![addExistingLocalGitRepository.png](addExistingLocalGitRepository.png)
8. Importare poi il progetto creato:
![localRepositoryEclipse.png](localRepositoryEclipse.png)
9. Effettuare il login su [travis-ci.org](https://travis-ci.org) e aggiungere la repository Github creata:
![newTravis.png](newTravis.png)


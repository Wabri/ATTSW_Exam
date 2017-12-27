1. creare una cartella gradle.example/first
2. creare il file build.gradle contenente:
```
description =  'Descrizione'

task compile {
    doLast {
        println 'compiling source'
    }
}

task compileTest(dependsOn: compile) {
    doLast {
        println 'compiling unit tests'
    }
}

task test(dependsOn: [compile, compileTest]) {
    doLast {
        println 'running unit tests'
    }
}

task dist(dependsOn: [compile, test]) {
    doLast {
        println 'building the distribution'
    }
}
```
3. eseguire la build:
`gradle dist`
4. eseguire la build precedente escludendo il task `test`:
`gradle dist -x test`
5. eseguire la build usando una abbreviazione:
`gradle coTe`
6. creare una build differente, chiamandola subbuild.gradle, in una subdirectory rispetto alla posizione iniziale contenente: 
```
description =  'Descrizione della subdirectory'

task hello {
    doLast {
        println "using build file '$buildFile.name' in '$buildFile.parentFile.name'."
    }
}
``` 
7. eseguire il task hello della build appena creata partendo dalla directory root:
`gradle -b subdir/myproject.gradle hello`
8. selezionare la subdirectory precedentemente creata come project directory principale:
`gradle -p subdir`
9. forzare l'esecuzione di un task marcato come UP-TO-DATE:
`gradle --rerun-tasks dist`
10. ottenere informazioni riguardo la build con il comando:
`gradle projects`
11. ottenere la lista dei tasks di default:
`gradle tasks`
12. ottenere la lista di tutti i tasks:
`gradle tasks --all`
13. aggiungere una descrizione al task dist:
```
task dist(dependsOn: [compile, test]) {
    description = 'Build distribution'
    doLast {
        println 'building the distribution'
    }
}
```
rieseguire il comando del punto 12 e vedere le differenze.
14. eseguire il comando:
`gradle help --task dist`

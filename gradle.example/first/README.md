1. Creare una cartella gradle.example/first
2. All'interno della nuova cartella creare il file build.gradle contenente:
```
description = 'Example of Task'

task dependenceZero {
	description = 'Build Dependence Zero'
	doFirst {
		println 'First Zero'
	}
	doLast {
		println 'Last Zero'
	}
}

task dependenceOne(dependsOn: [dependenceZero]) {
	description = 'Build Dependence One'
	doFirst {
		println 'First One'
	}
	doLast {
		println 'Last One'
	}
}

task dependenceTwo {
	description = 'Build Dependence Two'
	doFirst {
		println 'First Two'
	}
	doLast {
		println 'Last Two'
	}
}

task mainTask(dependsOn: [dependenceOne, dependenceTwo]) {
	description = 'Build Main Task'
	doFirst {
		println 'First MainTask'
	}
	doLast {
		println 'Last MainTask'
	}
}
```
3. eseguire la build:
`gradle mainTask`
4. Eseguire la build multi-tasks:
`gradle dependenceZero dependenceTwo`
5. eseguire la build usando una abbreviazione:
`gradle maTa`
6. eseguire la build precedente escludendo il task `dependenceOne`:
`gradle mainTask -x dependenceOne`
7. Creare una build differente in una subdirectory rispetto alla posizione iniziale: 
```
description = 'Sub directory'

task subMainTask {
	description = 'Sub Build Main Task'
	doFirst {
		println 'First MainTask'
	}
	doLast {
		println 'Last MainTask'
	}
}
```
8. Eseguire il task subMainTask della build appena creata partendo dalla directory root:
`gradle -b subdir/build.gradle suMT`
9. Forzare l'esecuzione di un task marcato come UP-TO-DATE:
`gradle --rerun-tasks dist`
10. Ottenere la lista dei tasks di default:
`gradle tasks`
11. Ottenere la lista di tutti i tasks:
`gradle tasks --all`
12. Eseguire il comando:
`gradle help --task mainTask`
13. Pubblicare la build del task mainTask:
`gradle mainTask --scan`

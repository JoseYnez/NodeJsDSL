job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
    scm {
        git('https://github.com/JoseYnez/NodeJsDSL.git', 'main') { node ->
            node / gitConfigName('JoseYnez')
            node / gitConfigEmail('yanezluis264@gmail.com')
        }
    }
    triggers {
        scm('H/1 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
    publishers {
    mailer('yanezluis264@gmail.com', false, true)
    }
}

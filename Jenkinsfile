
Jenkinsfile (Declarative Pipeline)

/* Requires the Docker Pipeline plugin */
pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
            }
        }
    }
}

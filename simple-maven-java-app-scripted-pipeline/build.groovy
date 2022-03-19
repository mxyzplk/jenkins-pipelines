node {
    withEnv(['NAME=my-app',
             'VERSION=1.0']) {

        stage('Checkout') {
            checkout scm
        }

        stage('Build') {
            sh 'mvn -B -DskipTests clean package'
        }

        stage('Test') {
            sh "mvn test"
        }

        stage('Package') {
            sh "mvn package"
        }

        stage('Deliver') {
            sh "chmod +x script.sh"
            sh "./script.sh"
        }
    }
}

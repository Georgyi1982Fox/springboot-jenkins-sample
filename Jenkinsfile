pipeline{
    agent any //it can run on jenkins master
    triggers{
       pollSCM '* * * * *' // we can do it every minute

    }
    stages{
        stage('Build')
            steps {
                sh './gradlew assemble'
            }
    }
    stage('Test') {
      steps {
         sh './gradlew test'
      }
    }
       stage(Build Docker image){
       steps{
         sh './gradlew docker'
       }
    }
    stage('Push Docker image'){
      environment {
         DOCKER_HUB_LOGIN = credentials('docker-hub')
      }
      steps{
        sh 'docker login --username=georg1982 --password=hjkesk1982
        sh './gradlew dockerPus'
      }
    }
}

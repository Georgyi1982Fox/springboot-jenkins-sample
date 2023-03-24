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
}
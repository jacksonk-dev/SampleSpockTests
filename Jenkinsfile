pipeline {
  agent any

  stages {
    stage('Jackson Build') {
      steps {
        echo 'Building..'
        sh '''
          cd /home/jekay/Desktop/SampleSpockTests
          ./gradlew l
        '''
      }
    }
    stage('Jackson Deploy') {
      steps {
        echo 'Building..'
      }
    }
  }
  post {
    always {
        archiveArtifacts artifacts: '*', onlyIfSuccessful: true
        // archiveArtifacts artifacts: '*/loans-acceptance-tests/build/spock-reports/*.html', onlyIfSuccessful: true
    }
  }
}

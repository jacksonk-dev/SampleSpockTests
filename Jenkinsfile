pipeline {
  agent any

  stages {
    stage('Jackson Build') {
      steps {
        echo 'Building..'
        sh '''
          cd /home/jekay/Desktop/SampleSpockTests
          rm -r loans-acceptance-tests/build
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
        archiveArtifacts artifacts: 'loans-acceptance-tests/build/spock-reports/*TestSpec.html', onlyIfSuccessful: true
    }
  }
}

import groovy.json.JsonOutput

def postReportToGezako(testReport) {
  // String fileContents = new File(testReport).getText('UTF-8');
  def post = new URL("https://us-central1-gezako-staging.cloudfunctions.net/app/cli").openConnection();
  def message = JsonOutput.toJson([from:"Gezako Jenkins yo"]);
  post.setRequestMethod("POST")
  post.setDoOutput(true)
  post.setRequestProperty("Content-Type", "application/json")
  post.getOutputStream().write(message.getBytes("UTF-8"));
  def postRC = post.getResponseCode();
  if(postRC.equals(200)) {
    println('Successfully Posted to Gezako');
  } else {
    println(postRC);
    println('Failed to post to Gezako');
  }
}

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
      echo 'Printing...'
      sh 'ls -a loans-acceptance-tests/build/spock-reports'
      echo 'Should be done printing'
      // archiveArtifacts artifacts: 'loans-acceptance-tests/build/spock-reports/*TestSpec.html', onlyIfSuccessful: true
      postReportToGezako('/home/jekay/Desktop/SampleSpockTests/loans-acceptance-tests/build/spock-reports/co.tala.acceptance.loans.specs.TestSpec.html')
    }
  }
}

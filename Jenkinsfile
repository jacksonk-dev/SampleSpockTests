def postReportToGezako() {
  def post = new URL("http://localhost:3000/jenkins-called").openConnection();
  def message = '{"Gezako Over"}'
  post.setRequestMethod("POST")
  post.setDoOutput(true)
  post.setRequestProperty("Content-Type", "application/json")
  post.getOutputStream().write(message.getBytes("UTF-8"));
  def postRC = post.getResponseCode();
  // println(postRC);
  if(postRC.equals(200)) {
    println('Successfully Posted to Gezako');
  } else {
    println('Failed to post to Gezaoko');
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
        archiveArtifacts artifacts: 'loans-acceptance-tests/build/spock-reports/*TestSpec.html', onlyIfSuccessful: true
        postReportToGezako()
    }
  }
}

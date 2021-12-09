def postReportToGezako(testReport) {
// https://us-central1-gezako-staging.cloudfunctions.net/app/cli

  @Grapes([
    @Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7'),
    @Grab('org.apache.httpcomponents:httpmime:4.5.1')
  ])

  String jsonText ='''{"parameter": [{"name":"test-report","file":"file0"}]}'''
  File file = new File(testReport);

  def http = new HTTPBuilder('https://us-central1-gezako-staging.cloudfunctions.net/app/cli')

  http.request(Method.POST, ContentType.TEXT) {req->
      MultipartEntityBuilder multipartRequestEntity = new MultipartEntityBuilder()
      multipartRequestEntity.addPart('file0', new FileBody(file, "text/html"))
      multipartRequestEntity.addPart('json', new StringBody(jsonText))

      req.entity =  multipartRequestEntity.build()

      response.success = { resp, data ->
          // response text
          println data.getText()
      }
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
      postReportToGezako('loans-acceptance-tests/build/spock-reports/co.tala.acceptance.loans.specs.TestSpec.html')
    }
  }
}

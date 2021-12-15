import groovy.json.JsonOutput

def printTest() {
  def message = JsonOutput.toJson([name:"Gezako", reportText: "fileContents"]);
  println(message)
}	

printTest()

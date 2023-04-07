import groovy.json.JsonSlurper

//configuration root path
def config_root_path = "${WORKSPACE}/jenkins_job"

//liux tree comand
def tree_command = "tree -J ${config_root_path}


//get root tree of jobs config in json format
def getJsonConfigTree(command) {
  def tree = ['bash' , '-c', "${command}"].execute().text
  return new JsonSlurper().parseText(tree)
}

def jsonProjectsStruct = getJsonConfigTree(tree_command)

for (jsonProjectStruct in jsonProjectStruct [0].contents) {
  jsonProjectStruct.info = jsonProjectStruct.name + "builds"
 
  //println dslBuildProject(jsonProjectStruct, [])
  
  //println dslBuildView(jsonProjectStruct)
  
}


println jsonProjectsStruct

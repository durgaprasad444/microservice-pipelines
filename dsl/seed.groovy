def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
         parameters{
    stringParam('ENV', 'DEV', 'What environment?')
    
}
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("myfile")
            }
        }
    }
}



def buildPipelineJobs() {
    def repo = "https://durga444@bitbucket.org/durga444/"
    def repoUrl = repo + jobName + ".git"
    def deployName = jobName + "_deploy"
    def testName = jobName + "_test"

    createDeploymentJob(deployName, repoUrl)
    
}

buildPipelineJobs()

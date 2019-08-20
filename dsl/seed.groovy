def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
         parameters{
    stringParam('DEV', 'What environment?', 'Environment')
    stringParam('DEV', 'QA', 'select environment')
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
                scriptPath("Jenkinsfile")
            }
        }
    }
}



def buildPipelineJobs() {
    def repo = "https://github.com/kcrane3576/"
    def repoUrl = repo + jobName + ".git"
    def deployName = jobName + "_deploy"
    def testName = jobName + "_test"

    createDeploymentJob(deployName, repoUrl)
    
}

buildPipelineJobs()

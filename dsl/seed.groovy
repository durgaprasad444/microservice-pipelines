def createDeploymentJob(jobName, repoUrl) {
    pipelineJob(jobName) {
         parameters {
        string(defaultValue: "DEV", description: 'What environment?', name: 'Environment')
        choice(choices: ['DEV', 'QA', 'QA2'], description: 'select environment', name: 'options')
        string(name: 'company_parameter', defaultValue: '', description: 'The company the pipeline runs in')
        string(name: 'test1', defaultValue: '', description: 'The company the pipeline runs in')
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

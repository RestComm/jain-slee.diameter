pipeline {
	agent any

	tools {
	    jdk 'JDK 11'
		maven 'Maven_3.6.3'
	}

	options {
    	buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '30', numToKeepStr: '10'))
  	}


	parameters {
        string(name: 'JSLEE_DIAMETER_MAJOR_VERSION_NUMBER', defaultValue: '7.2.1', description: 'The major version for RestComm JAIN SLEE Diameter')
        string(name: 'RESTCOMM_JDIAMETER_VERSION', defaultValue: '1.7.4-198', description: 'The version of RestComm jDiameter to use for build')
    }

	stages{
		stage('Set Version') {
			steps {
				sh "mvn versions:set -DnewVersion=${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"
			}
		}

		stage("Build") {
			steps {
				echo "Building application..."
				script {
                    currentBuild.displayName = "#${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"
                    currentBuild.description = "RestComm JAIN SLEE Diameter"
                }
				sh "mvn -Drestcomm.diameter.jdiameter.version=${params.RESTCOMM_JDIAMETER_VERSION} -Drestcomm.diameter.mux.version=${params.RESTCOMM_JDIAMETER_VERSION} clean install -DskipTests"
				echo "Maven build completed."
			}
		}

		stage("Release") {
			steps {
				echo "Building a release version of #${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"
        		sh "mvn clean install -Drestcomm.diameter.jdiameter.version=${params.RESTCOMM_JDIAMETER_VERSION} -Drestcomm.diameter.mux.version=${params.RESTCOMM_JDIAMETER_VERSION} -DskipTests -Prelease-wildfly -Drelease.dir=../../../deploy-${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"
				echo "Building a release version completed."
			}
		}

		stage('Save Artifacts') {
           //when { anyOf { branch 'release'; branch 'master' }}
            steps {
               echo "Archiving RestComm JAIN SLEE Diameter version ${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"
               archiveArtifacts artifacts: "deploy-${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}/", followSymlinks: false, onlyIfSuccessful: true
            }
        }

        stage('Push Artifacts'){
            when{ anyOf { branch 'release'; branch 'master' }}
            steps{
                script{
                    FOLDERNAME = "${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"
                }
                dir("deploy-${params.JSLEE_DIAMETER_MAJOR_VERSION_NUMBER}-${BUILD_NUMBER}"){
                    sh 'find resources/* -maxdepth 1 -type d -exec zip -r -qq {}.zip {} \\;'
                    sh "mkdir ${FOLDERNAME}"
                    sh "find resources/* -iname \"*.zip\" -exec mv {} ${FOLDERNAME}/ \\;"

                    sshagent(['ssh_grafana']) {
                       sh "scp -r ${FOLDERNAME} root@127.0.0.1:/var/www/html/FerUy/jain_slee_diameter"
                    }
                    sh "rm -rf ${FOLDERNAME}"
                }
            }
        }

        stage('jFrog'){
            when { anyOf { branch 'release'; branch 'master'}}
            steps{
                sh 'mvn deploy -DskipTests'
            }
        }
    }

	post {
		success {
			echo "Successfully build"
		}
		failure {
			echo "Building RestComm JAIN SLEE Diameter failed."
		}
		always {
            sh 'rm -rf deploy'
			echo 'The deploy folder is removed successfully'
		}
	}
}

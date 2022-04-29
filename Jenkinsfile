pipeline {
    agent any

    //triggers {
    //    pollSCM('*/3 * * * *')
    //}

    /*environment {
        imagename = "docker build로 만들 이미지 이름"
        registryCredential = 'docker hub credential ID'
        dockerImage = ''
    }

    stages {
        // git에서 repository clone
        stage('Prepare') {
          steps {
            echo 'Clonning Repository'
            git url: 'https://github.com/GoormAnchor/AnchorServer',
              branch: 'master',
              credentialsId: 'anchor-repo-credentials'
            }
            post {
             success { 
               echo 'Successfully Cloned Repository'
             }
           	 failure {
               error 'This pipeline stops here...'
             }
          }
        }*/

		stage('Checkout') {
        	checkout scm
    	}


        // gradle build
        stage('Bulid Gradle') {
          agent any
          steps {
            echo 'Bulid Gradle'
            dir ('.'){
                sh './gradlew clean build --exclude-task build.gradle'
            }
          }
          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }
        
        // docker build
        stage('Bulid Docker') {
          agent any
          steps {
            echo 'Bulid Docker'
            script {
                dockerImage = docker.build("anchor-book-be")
            }
          }
          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }

        // docker push
        stage('Push Docker') {
          agent any
          steps {
            echo 'Push Docker'
            script {
                  docker.withRegistry('438282170065.dkr.ecr.ap-northeast-2.amazonaws.com/anchor-book-be', 'anchor-ecr-credentials') {
                    dockerImage.push("latest")
                  }
            }
          }
          post {
            failure {
              error 'This pipeline stops here...'
            }
          }
        }
}
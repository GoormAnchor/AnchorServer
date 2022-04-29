pipeline {
    agent any

//
    environment {
        imagename = "anchor-book-be"
        registryCredential = 'anchor-ecr-credentials'
        dockerImage = ''
    }

    stages {
        // git에서 repository clone
        stage('Prepare') {
            steps {
                echo 'Clonning Repository'
                git url:'https://github.com/GoormAnchor/AnchorServer', branch:'master', credentialsId: 'anchor-repo-credentials';
            }
            post {
                success {
                    echo 'Successfully Cloned Repository'
                }
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        // gradle build
        stage('Bulid Gradle') {
            steps {
                echo 'Bulid Gradle'
                dir ('.') {
                    sh 'chmod +x gradlew'
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
            steps {
                echo 'Bulid Docker'
                script {
                    dockerImage = docker.build imagename
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
            steps {
                echo 'Push Docker'
                script {
                    docker.withRegistry('438282170065.dkr.ecr.ap-northeast-2.amazonaws.com/anchor-book-be', anchor-ecr-credentials) {
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
}
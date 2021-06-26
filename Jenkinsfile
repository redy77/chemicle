 pipeline {
     agent {
        label 'my-first-jenkins-script'
     }

     stages {
         stage('Build') {
             steps {
                 sh 'mvn -DskipTests clean package'
             }
         }
     }
 }
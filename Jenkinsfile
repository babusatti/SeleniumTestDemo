pipeline {
    agent { label 'windows' }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "Maven 3.3.9"
    }
    parameters { //string(name: 'username', defaultValue: 'sattibabu', description: 'enter your username')
    
        //password(name: 'password', defaultValue: 'admin', description: 'enter your password')
        string(name: 'sonarurl', defaultValue: 'https://github.com/login', description: 'enter sonar url here')
        string(name: 'fortifyurl', defaultValue: 'https://github.com/login', description: 'enter fortify url here')
        string(name: 'synurl', defaultValue: 'https://github.com/login', description: 'enter syn url here')
    }
    
   

    stages {
    
        stage('CheckOut') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'headless', url: 'https://github.com/babusatti/SeleniumTestDemo.git'

               
            }

           
        }
        stage('Build execute') {
           steps {
                withCredentials([usernamePassword(credentialsId: 'test-creds', passwordVariable: 'PASSWORD_VAR', usernameVariable: 'USERNAME_VAR')])
    {
        bat "mvn compile test -DsuiteXmlFile=testng.xml -Dusername=${USERNAME_VAR} -Dpassword=${PASSWORD_VAR} -Dsonarurl=${sonarurl} -Dfortifyurl=${fortifyurl} -Dsynurl=${synurl}"
    }
           }
        }
        stage('email') {
            steps {
                
               emailext attachmentsPattern: '**/*.png', body: 'Please find the sonar reports', recipientProviders: [developers(), requestor()], subject: 'Sonar-Reports', to: 'sattibabu0247@gmail.com'
            }
            
        }
    }
}

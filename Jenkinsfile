pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"
    }
    parameters { string(name: 'username', defaultValue: 'sattibabu', description: 'enter your username')
    
        password(name: 'password', defaultValue: 'admin', description: 'enter your password')
        string(name: 'sonarurl', defaultValue: 'https://github.com/login', description: 'enter sonar url here')
        string(name: 'fortifyurl', defaultValue: 'https://github.com/login', description: 'enter fortify url here')
        string(name: 'synurl', defaultValue: 'https://github.com/login', description: 'enter syn url here')
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'headless', url: 'https://github.com/babusatti/SeleniumTestDemo.git'

                // Run Maven on a Unix agent.
                bat "mvn compile test -DsuiteXmlFile=testng.xml"

                
            }

            
        }
    }
}

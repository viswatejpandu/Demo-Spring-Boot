pipeline{
    agent{
    
        label "slave_lbl"
    }
    stages{
        stage('git'){
            steps{
                git changelog: false, poll: false, url: 'https://github.com/viswatejpandu/DemoPro.git'
            }
        }
        stage('build'){
            steps{
                sh 'mvn clean spring-boot:run'
            }
        }
    }
    
    
}

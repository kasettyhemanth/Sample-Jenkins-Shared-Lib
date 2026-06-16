def call(String buildStatus, String channel) { 
   String message = "Job '${env.JOB_NAME}' - '${env.BUILD_NUMBER}' - ${buildStatus}"
   slackSend channel: channel, color: buildStatus == 'SUCCESS' ? 'good' : 'danger', message: message
}
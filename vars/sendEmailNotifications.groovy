def call(String buildStatus, String recipients) {
   String subject = "Job '${env.JOB_NAME}' - '${env.BUILD_NUMBER}' - ${buildStatus}"
   String  emailBody = """
   <!DOCTYPE html>
                    <html>
                    <head>
                        <style>
                            body { font-family: Arial, sans-serif; }
                            .header { background-color: #f4f5f7; padding: 10px; border-bottom: 2px solid #ccc; }
                            .success { color: green; font-weight: bold; }
                            .failure { color: red; font-weight: bold; }
                            .content { margin-top: 15px; }
                        </style>
                    </head>
                    <body>
                        <div class="header">
                            <h2>Jenkins Build Report</h2>
                        </div>
                        <div class="content">
                            <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                            <p><strong>Build Number:</strong> #${env.BUILD_NUMBER}</p>
                            <p><strong>Status:</strong> <span class="${buildStatus == 'SUCCESS' ? 'success' : 'failure'}">${buildStatus}</span></p>
                            <p>Please check the build logs for more details: <a href="${env.BUILD_URL}">here</a>.</p>
                        </div>
                    </body>
                    </html>'''
   """
   emailext body: emailBody, subject: subject, to: recipients, mimeType: 'text/html'
}
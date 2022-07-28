# PollinateAssignment


This is a simple proof of concept API that, for the sake of this demonstration runs on https://mojo.azurewebsites.net/
The api simply populates an azure SQL database with the time stamp of the request to https://mojo.azurewebsites.net/app

The following curl command can be used to test this api:
curl -X POST https://mojo.azurewebsites.net/app --ssl-no-revoke



Setup and Deploy
Use command to configure the web app service on Microsoft Azure. This application is made using maven so the following mvn command can be used to configure the azure web app service:
<strong> mvn com.microsoft.azure:azure-webapp-maven-plugin:2.5.0:config </strong>

In order to deploy the application, use the following command:
mvn package azure-webapp:deploy



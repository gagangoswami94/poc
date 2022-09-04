# Jenkins CI

This REPO contains POC on Jenkins CI 


## ec2-userdata contains all the bash scripts to add as user data in ec2 for setup of all tools

## Plugins used in jenkins

```bash
GitHub Integration
Nexus Artifacts Uploader
SonarQube Scanner
Slack Notification
Build timestamp
Maven Integration
```

```bash
If you are using s small instance, change the JVM memory parameters for sonarqube.
edit the parameters in /opt/nexus/nexus-3.41.1-01/bin/nexus.vmoptions
 Otherwise, nexus will not start
```

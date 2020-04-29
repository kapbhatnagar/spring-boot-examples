#docker build -f Dockerfile -t kapbhatnagar/kuberneteseg-a-mainapp . (kapbhatnagar/kuberneteseg-a-mainapp will 
	be the image name and dot means it will consider current path)
#docker push kapbhatnagar/kuberneteseg-a-mainapp
#Move deployment_service.yaml on google cloud editor
#Open command prompt
#Select project
#Create cluster and select it
#run cmd for create namespace: kubectl create namespace kuberneteseg
#run command: kubectl apply -f deployment_service.yaml
#to verify: kubectl get pods --namespace=kuberneteseg, kubectl get svc --namespace=kuberneteseg
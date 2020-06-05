docker stop json-horario-services-container
docker rm json-horario-services-container
docker build -t json-horario-services .
docker run -p 8181:8080 --name json-horario-services-container json-horario-services
docker start json-horario-services-container
#docker run --name ctrl-eval-back-container  --net ctrl-evaluaciones --ip 192.160.0.14 -p 8182:8182 meltsan/ctrl-eval-back:1.0
